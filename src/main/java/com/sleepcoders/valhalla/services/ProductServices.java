package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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

    public ResponseEntity<List<Product>> getAllProduct() {
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

///////////////////=======================================================/////////////////////////////////////////
    /////////////////////////===================productType filtering by regex===============================////////////////////////////

    public ResponseEntity<List<Product>> getProductsByProductType(String regex){
        List<Product> productList = productRepo.findAllByProductTypeMatchesRegex(regex).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
    ////////////////////========================rate sorting==========================////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingAsc(String regex) {
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.ASC, "rating")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingDesc(String regex) {
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.DESC, "rating")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
    ////////////////////========================model sorting==========================////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelAcs(String regex) {
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.ASC, "model")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelDesc(String regex) {
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.DESC, "model")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
    ////////////////////========================name sorting==========================////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameAcs(String regex) {
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.ASC, "name")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameDesc(String regex) {
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.DESC, "name")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

////////////////////========================price sorting==========================////////////////////////////

    public ResponseEntity<List<Product>> getProductByProductTypeAndPriceAcs(String regex, double min, double max) {
        List<Product> productList = productRepo.findAllByProductType_AndPrice(regex, min, max, Sort.by(Sort.Direction.ASC, "price")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getProductByProductTypeAndPriceDesc(String regex, double min, double max) {
        List<Product> productList = productRepo.findAllByProductType_AndPrice(regex, min, max, Sort.by(Sort.Direction.DESC, "price")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    ////////////////////========================yearOfProduction sorting==========================////////////////////////////

    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionAcs(String regex){
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.ASC,"yearOfProduction")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionDesc(String regex){
        List<Product> productList = productRepo.findAllByProductType(regex, Sort.by(Sort.Direction.DESC,"yearOfProduction")).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
    ////////////////////========================rating from value==========================////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRating(String regex , double rating){
        List<Product> productList = productRepo.findAllByProductTypeMatchesRegexAndRating(regex,rating).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
    ////////////////////========================in stock filtering==========================////////////////////////////

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndInStock(String regex){
        List<Product> productList = productRepo.findAllByProductTypeMatchesRegexAndInStock(regex).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
    /////////////////////////========================searchBar filtering=================================///////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByKeyWord(String keyWord){
        List<Product> productList = productRepo.findAllBySearchKeyWord(keyWord).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);

    }

}
