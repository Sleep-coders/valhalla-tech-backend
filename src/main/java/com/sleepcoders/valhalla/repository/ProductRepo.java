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
    @Query(value = "SELECT * FROM product where product_type regexp ?1", nativeQuery = true)
    Optional<List<Product>> findAllByProductType(String productType, Sort sorter);

    @Modifying
    @Query(value = "SELECT * FROM product where product_type regexp ?1 and(price >= ?2 and price >= ?3)", nativeQuery = true)
    Optional<List<Product>> findAllByProductType_AndPrice(String productType, double min, double max, Sort price);

    @Modifying
    @Query(value = "SELECT * FROM product where product_type regexp ?1", nativeQuery = true)
    Optional<List<Product>> findAllByProductTypeMatchesRegex(String regex);

    @Modifying
    @Query(value = "SELECT * FROM product where product_type regexp ?1 and rating >= ?2", nativeQuery = true)
    Optional<List<Product>> findAllByProductTypeMatchesRegexAndRating(String regex, double rating);

    @Modifying
    @Query(value = "SELECT * FROM product where product_type regexp ?1 and quantity > 0", nativeQuery = true)
    Optional<List<Product>> findAllByProductTypeMatchesRegexAndInStock(String regex);
    @Modifying
    @Query(value = "SELECT * FROM product where name contains ?1 or description contains ?1 or brand contains ?1 or model contains ?1", nativeQuery = true)
    Optional<List<Product>> findAllBySearchKeyWord(String keyWord);

}
