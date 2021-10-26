package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.users.User;
import com.sleepcoders.valhalla.repository.UserRepository;
import com.sleepcoders.valhalla.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/email")
public class EmailController {

    private final EmailServices emailServices;
    private final UserRepository userRepository;

    @Autowired
    public EmailController(EmailServices emailServices, UserRepository userRepository) {
        this.emailServices = emailServices;
        this.userRepository = userRepository;
    }


    @GetMapping("/invoice/{userId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String sendEmail(Model model, @PathVariable Long userId) {
        User user = userRepository.getById(userId);
        model.addAttribute("user", user);
        return "invoice";
//        return emailServices.sendEmailWithInvoiceAttachment(model, userId);
    }

    @GetMapping("/advertisement")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> sendEmail(Model model, @RequestBody Product product) {
//        model.addAttribute("product", product);
        return emailServices.sendEmailWithAdvertisingAttachment(model, product);
    }
}

