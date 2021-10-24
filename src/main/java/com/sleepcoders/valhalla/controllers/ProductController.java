package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllProducts() {
        return productServices.getAllProduct();
    }

    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void addNewProduct(@RequestBody Product product) {
        productServices.addNewProduct(product);
    }

    @DeleteMapping("/{productId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void removeProduct(@PathVariable Long productId) {
        productServices.removeProduct(productId);
    }

    @PutMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void updateProduct(@RequestBody Product product) {
        productServices.updateProduct(product);
    }

    /////////////////////////===================productType filtering by regex===============================///////////////////////////////

    @GetMapping("/productType/{regex}")
    public ResponseEntity<List<Product>> getProductsByProductType(@PathVariable String regex) {
        return productServices.getProductsByProductType(regex);
    }

    /////////////////////////=========================price sorting================================///////////////////////////////
    @GetMapping("/filterPrice/Acs/{regex}/{min}/{max}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByPriceAcs(@PathVariable String regex, @PathVariable double min, @PathVariable double max) {
        return productServices.getProductByProductTypeAndPriceAcs(regex, min, max);
    }

    @GetMapping("/filterPrice/Desc/{regex}/{min}/{max}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByPriceDesc(@PathVariable String regex, @PathVariable double min, @PathVariable double max) {
        return productServices.getProductByProductTypeAndPriceDesc(regex, min, max);
    }
    /////////////////////////========================rate sorting=================================///////////////////////////////

    @GetMapping("/filterRating/Acs/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingAsc(@PathVariable String regex) {
        return productServices.getAllProductByProductTypeAndRatingAsc(regex);
    }
    @GetMapping("/filterRating/Desc/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingDesc(@PathVariable String regex) {
        return productServices.getAllProductByProductTypeAndRatingDesc(regex);
    }


    /////////////////////////========================model sorting=================================///////////////////////////////

    @GetMapping("/filterModel/Acs/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelAcs(@PathVariable String regex) {
        return productServices.getAllProductByProductTypeAndModelAcs(regex);
    }
    @GetMapping("/filterModel/Desc/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelDesc(@PathVariable String regex) {
        return productServices.getAllProductByProductTypeAndModelDesc(regex);
    }


    /////////////////////////========================name sorting=================================///////////////////////////////


    @GetMapping("/filterName/Acs/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameAcs(@PathVariable String regex) {
        return productServices.getAllProductByProductTypeAndNameAcs(regex);
    }
    @GetMapping("/filterName/Desc/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameDesc(@PathVariable String regex) {
        return productServices.getAllProductByProductTypeAndNameDesc(regex);
    }
    /////////////////////////========================yearOfProduction sorting=================================///////////////////////////////

    @GetMapping("/filterYearOfProduction/Acs/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionAcs(@PathVariable String regex){
        return productServices.getProductByProductTypeAndYearOfProductionAcs(regex);
    }
    @GetMapping("/filterYearOfProduction/Desc/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionDesc(@PathVariable String regex){
        return productServices.getProductByProductTypeAndYearOfProductionDesc(regex);
    }
    /////////////////////////========================rating from value=================================///////////////////////////////
    @GetMapping("/filterRating/{regex}/{rating}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRating(@PathVariable String regex,@PathVariable double rating) {
        return productServices.getAllProductByProductTypeAndRating(regex,rating);
    }
    /////////////////////////========================in stoke filtering=================================///////////////////////////////
    @GetMapping("/filterInStock/{regex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndInStock(@PathVariable String regex){
        return productServices.getAllProductByProductTypeAndInStock(regex);
    }

    /////////////////////////========================searchBar filtering=================================///////////////////////////////
    @GetMapping("/filterKeyWord/{keyWord}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByKeyWord(@PathVariable String keyWord){
        return productServices.getAllProductByKeyWord(keyWord);
    }
}
