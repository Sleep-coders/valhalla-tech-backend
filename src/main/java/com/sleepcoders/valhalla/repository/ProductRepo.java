package com.sleepcoders.valhalla.repository;

import com.sleepcoders.valhalla.models.products.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Modifying
    @Query(value = "SELECT * FROM product where product_type = ?1", nativeQuery = true)
    Optional<List<Product>> findAllByProductType(String productType);

    @Modifying
    @Query(value = "SELECT * FROM product where product_type = ?1", nativeQuery = true)
    Optional<List<Product>> findAllByProductType(String productType, Sort sorter);

    @Modifying
    @Query(value = "SELECT * FROM product where product_type = ?1 and price >= ?2 and price >= ?3", nativeQuery = true)
    Optional<List<Product>> findAllByProductType_AndPrice(String productType,double min, double max, Sort price);

}
