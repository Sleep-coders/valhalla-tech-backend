package com.sleepcoders.valhalla.repository;

import com.sleepcoders.valhalla.models.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product , Long> {
    @Query(value="select * from product where product_type = ?1",nativeQuery = true)
    Optional<List<Product>> findAllByProductType(String type);
}
