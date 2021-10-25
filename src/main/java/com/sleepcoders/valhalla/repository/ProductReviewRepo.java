package com.sleepcoders.valhalla.repository;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.models.reviews.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepo extends JpaRepository<ProductReview, Long> {

    @Modifying
    @Query(value = "select r from ProductReview r where r.product = ?1")
    List<ProductReview> findProductReviewsByProductId(Long productId);
}
