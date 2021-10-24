package com.sleepcoders.valhalla.repository;

import com.sleepcoders.valhalla.models.reviews.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<ProductReview, Long> {

}
