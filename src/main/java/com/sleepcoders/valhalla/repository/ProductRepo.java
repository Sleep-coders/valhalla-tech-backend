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

    //We can use contains instead of regex.(give it a try!)
//    @Modifying
    @Query(value = "SELECT * FROM product where product_type LIKE ?1", nativeQuery = true)
    Optional<List<Product>> findAllByProductType(String productType);

//    @Modifying
    @Query(value = "SELECT * FROM product where product_type LIKE ?1 and(price >= ?2 and price <= ?3)", nativeQuery = true)
    Optional<List<Product>> findAllByProductType_AndPrice(String productType, double min, double max);

//    @Modifying
    @Query(value = "SELECT * FROM product where product_type LIKE ?1 and rating >= ?2", nativeQuery = true)
    Optional<List<Product>> findAllByProductTypeAndRating(String productType, double rating);

//    @Modifying
    @Query(value = "SELECT * FROM product where product_type LIKE ?1 and quantity > 0", nativeQuery = true)
    Optional<List<Product>> findAllByProductTypeAndInStock(String productType);

//    @Modifying
    @Query(value = "SELECT * FROM product where name LIKE ?1 or description LIKE ?1 or brand LIKE ?1 or model LIKE ?1", nativeQuery = true)
    Optional<List<Product>> findAllBySearchKeyWord(String keyWord);

}
