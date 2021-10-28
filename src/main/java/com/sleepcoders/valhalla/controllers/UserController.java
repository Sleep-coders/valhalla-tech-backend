package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.dataStorage.DataStorage;
import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.user_purchases_request.PurchaseRequest;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.repository.DataStorageRepo;
import com.sleepcoders.valhalla.services.implementation.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;
    private final DataStorage dataStorage;
    private final DataStorageRepo dataStorageRepo;
    @Autowired
    public UserController(UserServices userServices, DataStorageRepo dataStorageRepo) {
        this.userServices = userServices;
        dataStorage = dataStorageRepo.getById(1L);
        this.dataStorageRepo = dataStorageRepo;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return userServices.getUser(userId);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        return userServices.getAllUsers();
    }

    @GetMapping("purchases/{userId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Product>> getPurchasesHistory(@PathVariable Long userId){
        return userServices.getPurchasesHistory(userId);
    }


    @PostMapping("/purchases")
    @PreAuthorize("hasRole('USER')")
    public void confirmUserPurchases(@RequestBody PurchaseRequest purchaseRequest){
        userServices.confirmUserPurchases(purchaseRequest);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long userId) {

        userServices.deleteUser(userId);
        dataStorage.setCountOfUsersDec(1);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public void updateUser(@RequestBody User user) {
        userServices.updateUser(user);
    }


}