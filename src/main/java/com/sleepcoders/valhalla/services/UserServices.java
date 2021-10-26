package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.dataStorage.DataStorage;
import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.user_purchases_request.PurchaseRequest;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.repository.DataStorageRepo;
import com.sleepcoders.valhalla.repository.ProductRepo;
import com.sleepcoders.valhalla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    private final DataStorageRepo dataStorageRepo;
    private final UserRepository userRepository;
    private final ProductRepo productRepo;

    @Autowired
    public UserServices(DataStorageRepo dataStorageRepo, UserRepository userRepository, ProductRepo productRepo) {
        this.dataStorageRepo = dataStorageRepo;
        this.userRepository = userRepository;
        this.productRepo = productRepo;

    }


    public ResponseEntity<?> getUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null)
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.badRequest().body("There is no user with Id: " + userId);
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<List<Product>> confirmUserPurchases(PurchaseRequest purchaseRequest) {
        User user = userRepository.getById(purchaseRequest.getUserId());
        user.setBalance(4000);
        List<Product> productList = new ArrayList<>();
        double totalPrice = 0.0;

        for (String productId : purchaseRequest.getProductIdProductQuantity().keySet()) {
            Product product = productRepo.getById(Long.parseLong(productId));
            totalPrice += product.getPrice();
            productList.add(product);
        }

        if (user.getBalance() < totalPrice)
            return ResponseEntity.badRequest().body(new ArrayList<>());

        for(String productId : purchaseRequest.getProductIdProductQuantity().keySet()){
            Product product = productRepo.getById(Long.parseLong(productId));
            product.setQuantity(product.getQuantity() - purchaseRequest.getProductIdProductQuantity().get(productId));
            productRepo.save(product);
        }

        productList.addAll(user.getProductList());

        DataStorage dataStorage = dataStorageRepo.getById(1L);
        dataStorage.setTotalOfSales(totalPrice);
        dataStorageRepo.save(dataStorage);
        user.setBalance(user.getBalance() - totalPrice);
        user.setProductList(productList);
        return ResponseEntity.ok(productList);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }


}
