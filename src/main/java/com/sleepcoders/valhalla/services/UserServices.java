package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.user_purchases_request.PurchaseRequest;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.repository.ProductRepo;
import com.sleepcoders.valhalla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    private final UserRepository userRepository;
    private final ProductRepo productRepo;

    @Autowired
    public UserServices(UserRepository userRepository, ProductRepo productRepo) {
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
        user.setBalance(getRandBalance(2000, 4000));
        List<Product> productList = new ArrayList<>();
        double totalPrice = 0.0;

        for (Long productId : purchaseRequest.getProductsIds()) {
            Product product = productRepo.getById(productId);
            totalPrice += product.getPrice();
            productList.add(product);
        }

        if (user.getBalance() < totalPrice)
            return ResponseEntity.badRequest().body(new ArrayList<>());

        productList.addAll(user.getProductList());

        user.setProductList(productList);
        return ResponseEntity.ok(productList);
    }

    private double getRandBalance(int min, int max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
