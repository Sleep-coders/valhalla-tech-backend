package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailServices emailServices;

    @Autowired
    public EmailController(EmailServices emailServices) {
        this.emailServices = emailServices;
    }


    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void sendEmail(@RequestBody Product product){
        emailServices.sendEmail(product);
    }

}
