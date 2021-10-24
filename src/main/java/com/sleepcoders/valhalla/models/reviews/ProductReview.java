package com.sleepcoders.valhalla.models.reviews;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.relations.ProductReviewKey;
import com.sleepcoders.valhalla.models.users.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProductReview {

    @EmbeddedId
    ProductReviewKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private String title;

    private String reviewContent;

    private double rating;

    private LocalDateTime createdAt;

    public ProductReview() {
    }

    public ProductReview(Product product, String title, String reviewContent, double rating) {
        this.product = product;
        this.title = title;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.createdAt = LocalDateTime.now();
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ProductReviewKey getId() {
        return id;
    }

    public void setId(ProductReviewKey id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
