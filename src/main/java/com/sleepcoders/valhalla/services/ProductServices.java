package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    private final ProductRepo productRepo;


    @Autowired
    public ProductServices(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ResponseEntity<?> getAllProduct(String Authorization) {
        List<Product> productList = productRepo.findAll();
        return ResponseEntity.ok(productList);
    }

    public void addNewProduct(Product product) {
        productRepo.save(product);
    }

    public void removeProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    public ResponseEntity<List<Product>> getProductsByProductType(String productType){
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingAsc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType, Sort.by(Sort.Direction.ASC, "rating")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType, Sort.by(Sort.Direction.DESC, "rating")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelAcs(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType, Sort.by(Sort.Direction.ASC, "model")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType, Sort.by(Sort.Direction.DESC, "model")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameAcs(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType, Sort.by(Sort.Direction.ASC, "name")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType, Sort.by(Sort.Direction.DESC, "name")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getProductByProductTypeAndPriceAcs(String productType, double min, double max) {
        List<Product> productList = productRepo.findAllByProductType_AndPrice(productType, min, max, Sort.by(Sort.Direction.ASC, "price")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getProductByProductTypeAndPriceDesc(String productType, double min, double max) {
        List<Product> productList = productRepo.findAllByProductType_AndPrice(productType, min, max, Sort.by(Sort.Direction.DESC, "price")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

}
