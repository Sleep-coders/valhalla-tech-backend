package com.sleepcoders.valhalla.repository;

import com.sleepcoders.valhalla.models.products.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product where product_type LIKE '%' || ?1 || '%' and (price >= ?2 and price <= ?3) and rating >= ?4 and quantity > 0", nativeQuery = true)
    Optional<List<Product>> findAllByProductTypeAndFilterParamsInStock(String productType, double min, double max, double rating);

    @Query(value = "SELECT * FROM product where product_type LIKE '%' || ?1 || '%' and (price >= ?2 and price <= ?3) and rating >= ?4 and quantity >= 0", nativeQuery = true)
    Optional<List<Product>> findAllByProductTypeAndFilterParams(String productType, double min, double max, double rating);

    @Query(value = "SELECT * FROM product where product_type LIKE '%' || ?1 || '%'", nativeQuery = true)
    Optional<List<Product>> findAllByProductType(String productType);

    @Query(value = "SELECT * FROM product where name LIKE '%' || ?1 || '%' or description LIKE '%' || ?1 || '%' or brand LIKE '%' || ?1 || '%' or model LIKE '%' || ?1 || '%'", nativeQuery = true)
    Optional<List<Product>> findAllBySearchKeyWord(String keyWord);

//    Optional<List<Product>> findAllByProductTypeAndPriceBetweenAndRatingGreaterThanEqualAndQuantityGreaterThan(String productType, double minPrice, double maxPrice, int stars, int starterValue);
//
//    Optional<List<Product>> findAllByProductTypeContains(String productType);
//
//    Optional<List<Product>> findAllByNameContainsAndDescriptionContainsAndBrandContainsAndModelContains(String name, String description, String brand, String model);


}
