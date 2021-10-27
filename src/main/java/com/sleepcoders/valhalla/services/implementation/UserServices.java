package com.sleepcoders.valhalla.services.implementation;

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
        System.out.println("purchase "+purchaseRequest.getUserId());
        System.out.println("users "+userRepository.findAll());

        User user = userRepository.findById(purchaseRequest.getUserId()).orElse(null);
        System.out.println(user);
        Long[] productsIds = purchaseRequest.getProductsIds();
        int[] productsQuantity = purchaseRequest.getProductsQuantity();
        user.setBalance(4000);
        List<Product> productList = new ArrayList<>();
        double totalPrice = 0.0;

        for (Long productId :productsIds ) {
            Product product = productRepo.findById(productId).orElse(null);
            totalPrice += product.getPrice();
            productList.add(product);
        }

        if (user.getBalance() < totalPrice)
            return ResponseEntity.badRequest().body(new ArrayList<>());

        for(int i=0; i<productsIds.length; i++){
            Product product = productRepo.findById(productsIds[i]).orElse(null);
            product.setQuantity(product.getQuantity() - productsQuantity[i]);
            productRepo.save(product);
        }

        productList.addAll(user.getProductList());

        DataStorage dataStorage = dataStorageRepo.getById(1L);
        dataStorage.setTotalOfSales(totalPrice);
        dataStorageRepo.save(dataStorage);
        user.setBalance(user.getBalance() - totalPrice);
        user.setProductList(productList);
        user.setLastPayment(totalPrice);
        return ResponseEntity.ok(productList);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }


}
