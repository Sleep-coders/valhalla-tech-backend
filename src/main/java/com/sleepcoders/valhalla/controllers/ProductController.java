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
    public ResponseEntity<?> getAllProducts(@RequestHeader String Authorization) {
        return productServices.getAllProduct(Authorization);
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

    @GetMapping("/{productType}")
    public ResponseEntity<List<Product>> getProductsByProductType(@PathVariable String productType) {
        return productServices.
    }

    @GetMapping("/filterPrice/{min}/{max}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByPrice(@PathVariable String productType, @PathVariable double min, @PathVariable double max) {
       return productServices.getProductByPrice(productType ,min, max);
    }

}
