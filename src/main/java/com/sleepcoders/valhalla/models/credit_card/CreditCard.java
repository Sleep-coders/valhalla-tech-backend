package com.sleepcoders.valhalla.models.credit_card;

import javax.persistence.*;

@Entity
@Table(name = "credit-card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long creditCardNumber;

    private String cvv;

    private String expDate;

    private String creditCardOwnerName;

    public CreditCard() {
    }

    public CreditCard(Long creditCardNumber, String cvv, String expDate, String creditCardOwnerName) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.expDate = expDate;
        this.creditCardOwnerName = creditCardOwnerName;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCreditCardOwnerName() {
        return creditCardOwnerName;
    }

    public void setCreditCardOwnerName(String creditCardOwnerName) {
        this.creditCardOwnerName = creditCardOwnerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
