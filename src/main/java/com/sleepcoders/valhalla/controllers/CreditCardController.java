package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.credit_card.CreditCard;
import com.sleepcoders.valhalla.services.CreditCardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/creditCards")
public class CreditCardController {

    private final CreditCardServices creditCardServices;

    @Autowired
    public CreditCardController(CreditCardServices creditCardServices) {
        this.creditCardServices = creditCardServices;
    }

    @GetMapping("/{creditCardId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getUserCreditCard(@PathVariable Long creditCardId) {
        return creditCardServices.getUserCreditCard(creditCardId);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public CreditCard addUserCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardServices.addUserCreditCard(creditCard);
    }

    @DeleteMapping("/{creditCardId}")
    @PreAuthorize("hasRole('USER')")
    public void deleteUserCreditCard(@PathVariable Long creditCardId) {
        creditCardServices.deleteUserCreditCard(creditCardId);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public CreditCard updateUserCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardServices.updateUserCreditCard(creditCard);
    }

}
