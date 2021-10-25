package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.credit_card.CreditCard;
import com.sleepcoders.valhalla.repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServices {

    public final CreditCardRepo creditCardRepo;

    @Autowired
    public CreditCardServices(CreditCardRepo creditCardRepo) {
        this.creditCardRepo = creditCardRepo;
    }


    public ResponseEntity<?> getUserCreditCard(Long creditCardId){
        CreditCard creditCard = creditCardRepo.findById(creditCardId).orElse(null);

        if(creditCard != null)
            return ResponseEntity.ok(creditCard);
        else
            return ResponseEntity.badRequest().body("There is no card of the Id: " + creditCardId);
    }

    public CreditCard addUserCreditCard(CreditCard creditCard){
        return creditCardRepo.save(creditCard);
    }

    public void deleteUserCreditCard(Long creditCardId){
        creditCardRepo.deleteById(creditCardId);
    }

    public CreditCard updateUserCreditCard(CreditCard creditCard){
        return creditCardRepo.save(creditCard);
    }

}
