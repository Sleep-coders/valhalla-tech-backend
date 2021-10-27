package com.sleepcoders.valhalla.services.implementation;

import com.sleepcoders.valhalla.models.reviews.ProductReview;
import com.sleepcoders.valhalla.repository.ProductReviewRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewServices {

    private final ProductReviewRepo productReviewRepo;

    public ProductReviewServices(ProductReviewRepo productReviewRepo) {
        this.productReviewRepo = productReviewRepo;
    }

    public ResponseEntity<List<ProductReview>> getProductReviews(Long productId){
        List<ProductReview> productReviews = productReviewRepo.findProductReviewsByProductId(productId);
        return ResponseEntity.ok(productReviews);
    }

    public void addProductReview(ProductReview productReview){
        productReviewRepo.save(productReview);
    }

    public void deleteProductReview(Long productReviewId){
        productReviewRepo.deleteById(productReviewId);
    }

    public void updateProductReview(ProductReview productReview){
        productReviewRepo.save(productReview);
    }
}
