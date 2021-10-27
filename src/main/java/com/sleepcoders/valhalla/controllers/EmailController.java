package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.repository.UserRepository;
import com.sleepcoders.valhalla.services.implementation.EmailServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailServicesImp emailServicesImp;
    private final UserRepository userRepository;

    @Autowired
    public EmailController(EmailServicesImp emailServicesImp, UserRepository userRepository) {
        this.emailServicesImp = emailServicesImp;
        this.userRepository = userRepository;
    }


    @GetMapping("/invoice/{userId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> sendEmail(@PathVariable Long userId) {
        return emailServicesImp.emailSender(userId);
    }

    @GetMapping("/advertisement")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> sendEmail(@RequestBody Product product) {
        return emailServicesImp.emailSender(product);
    }
}

