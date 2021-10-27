package com.sleepcoders.valhalla.models.users;

import com.sleepcoders.valhalla.models.credit_card.CreditCard;
import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.reviews.ProductReview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    private String firstName;
    private String lastName;
    private String imageUrl;
    private double balance;
    private double lastPayment;

    @ManyToMany
    @JoinTable(name = "user_product_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    @OneToMany(mappedBy = "user")
    private Set<ProductReview> productReviews;

    @OneToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String email, String password, String firstName, String lastName, String imageUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.balance = 0.0;
        this.lastPayment = 0.0;
        this.productList = new ArrayList<>();
        this.productReviews = new HashSet<>();
        this.roles = new HashSet<>();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Set<ProductReview> getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(Set<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public double getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(double lastPayment) {
        this.lastPayment = lastPayment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", balance=" + balance +
                ", lastPayment=" + lastPayment +
                ", productList=" + productList +
                ", productReviews=" + productReviews +
                ", creditCard=" + creditCard +
                ", roles=" + roles +
                '}';
    }
}