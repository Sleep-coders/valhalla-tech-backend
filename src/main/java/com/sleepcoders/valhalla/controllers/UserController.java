package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.user_purchases_request.PurchaseRequest;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.services.UserServices;
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

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
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

    @PostMapping("/purchases")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> confirmUserPurchases(@RequestBody PurchaseRequest purchaseRequest){
        return userServices.confirmUserPurchases(purchaseRequest);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long userId) {
        userServices.deleteUser(userId);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public void updateUser(@RequestBody User user) {
        userServices.updateUser(user);
    }

}