package com.sleepcoders.valhalla.repository;

import com.sleepcoders.valhalla.models.credit_card.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Long> {
}
