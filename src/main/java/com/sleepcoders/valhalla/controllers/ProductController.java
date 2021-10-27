package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.product_filtering_request.ProductFilteringRequest;
import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.services.implementation.ProductServices;
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


    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProducts() {
        return productServices.getAllProduct();
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return productServices.getProductById(productId);
    }

    ///////////////////////==============Different Products Endpoints============///////////////

    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> addNewProduct(@RequestBody Product product) {
        return productServices.addNewProduct(product);
    }

    ///////////////////////////////===================================================////////////////////////
    @DeleteMapping("/{productId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> removeProduct(@PathVariable Long productId) {
       return productServices.removeProduct(productId);
    }

    ///////////////////////==============================update Products===================================///////////////////

    @PutMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> updateProduct(@RequestBody Product product) {
        return productServices.updateProduct(product);
    }

    /////////////////////////===================productType filtering by productType===============================///////////////////////////////

    @GetMapping("/productType/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByProductType(@PathVariable String productType) {
        return productServices.getProductsByProductType(productType);
    }

    ///////////////////////=========================price sorting================================///////////////////////////////

    @GetMapping("/filter/{productType}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Product>> getProductsByFilter(ProductFilteringRequest productFilteringRequest, @PathVariable String productType){
        return productServices.getProductsByFilter(productFilteringRequest, productType);
    }

    @GetMapping("/filterPrice/Acs/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByPriceAcs(@PathVariable String productType) {
        return productServices.getProductByProductTypeAndPriceAcs(productType);
    }

    @GetMapping("/filterPrice/Desc/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByPriceDesc(@PathVariable String productType) {
        return productServices.getProductByProductTypeAndPriceDesc(productType);
    }
    /////////////////////////========================rate sorting=================================///////////////////////////////

    @GetMapping("/filterRating/Acs/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingAsc(@PathVariable String productType) {
        return productServices.getAllProductByProductTypeAndRatingAsc(productType);
    }

    @GetMapping("/filterRating/Desc/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingDesc(@PathVariable String productType) {
        return productServices.getAllProductByProductTypeAndRatingDesc(productType);
    }

    /////////////////////////========================model sorting=================================///////////////////////////////

    @GetMapping("/filterModel/Acs/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelAcs(@PathVariable String productType) {
        return productServices.getAllProductByProductTypeAndModelAcs(productType);
    }

    @GetMapping("/filterModel/Desc/{productTypeRegex}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelDesc(@PathVariable String productTypeRegex) {
        return productServices.getAllProductByProductTypeAndModelDesc(productTypeRegex);
    }

    /////////////////////////========================name sorting=================================///////////////////////////////


    @GetMapping("/filterName/Acs/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameAcs(@PathVariable String productType) {
        return productServices.getAllProductByProductTypeAndNameAcs(productType);
    }

    @GetMapping("/filterName/Desc/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameDesc(@PathVariable String productType) {
        return productServices.getAllProductByProductTypeAndNameDesc(productType);
    }
    /////////////////////////========================yearOfProduction sorting=================================///////////////////////////////

    @GetMapping("/filterYearOfProduction/Acs/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionAcs(@PathVariable String productType) {
        return productServices.getProductByProductTypeAndYearOfProductionAcs(productType);
    }

    @GetMapping("/filterYearOfProduction/Desc/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionDesc(@PathVariable String productType) {
        return productServices.getProductByProductTypeAndYearOfProductionDesc(productType);
    }

    /////////////////////////========================searchBar filtering=================================///////////////////////////////
    @GetMapping("/filterKeyWord/{keyWord}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByKeyWord(@PathVariable String keyWord) {
        return productServices.getAllProductByKeyWord(keyWord);
    }
}
