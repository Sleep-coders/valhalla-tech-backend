package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.reviews.ProductReview;
import com.sleepcoders.valhalla.services.ProductReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/reviews")
public class ReviewController {

    private final ProductReviewServices productReviewServices;

    @Autowired
    public ReviewController(ProductReviewServices productReviewServices) {
        this.productReviewServices = productReviewServices;
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<ProductReview>> getProductReviews(@PathVariable Long productId) {
        return productReviewServices.getProductReviews(productId);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public void addProductReview(@RequestBody ProductReview productReview) {
        productReviewServices.addProductReview(productReview);
    }

    @DeleteMapping("/{productReviewId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteProductReview(@PathVariable Long productReviewId) {
        productReviewServices.deleteProductReview(productReviewId);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public void updateProductReview(@RequestBody ProductReview productReview) {
        productReviewServices.updateProductReview(productReview);
    }
}
