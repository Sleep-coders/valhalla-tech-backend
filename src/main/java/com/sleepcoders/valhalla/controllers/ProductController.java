package com.sleepcoders.valhalla.controllers;


import com.sleepcoders.valhalla.models.product_filtering_request.ProductFilteringRequest;
import com.sleepcoders.valhalla.models.products.Product;
//import com.sleepcoders.valhalla.models.products.computers.Desktop;
//import com.sleepcoders.valhalla.models.products.computers.Laptop;
//import com.sleepcoders.valhalla.models.products.entertainment.GamingConsole;
//import com.sleepcoders.valhalla.models.products.entertainment.TV;
//import com.sleepcoders.valhalla.models.products.homeappliances.Refrigerator;
//import com.sleepcoders.valhalla.models.products.homeappliances.VacuumMachine;
//import com.sleepcoders.valhalla.models.products.homeappliances.WashingMachine;
//import com.sleepcoders.valhalla.models.products.smartphones.SmartPhone;
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

    @PostMapping("/{productType}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> addNewProduct(@RequestBody Product product, @PathVariable String productType) {
        productServices.addNewProduct(product);
        return productServices.getProductsByProductType(productType);
    }

//    @PostMapping("/laptop/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody Laptop laptop, @PathVariable String productType) {
//        productServices.addNewProduct(laptop);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PostMapping("/desktop/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody Desktop desktop, @PathVariable String productType) {
//        productServices.addNewProduct(desktop);
//        return productServices.getProductsByProductType(productType);
//    }
//
//
//    @PostMapping("/gamingConsole/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody GamingConsole gamingConsole, @PathVariable String productType) {
//        productServices.addNewProduct(gamingConsole);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PostMapping("/tv/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody TV tv, @PathVariable String productType) {
//        productServices.addNewProduct(tv);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PostMapping("/refrigerator/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody Refrigerator refrigerator, @PathVariable String productType) {
//        productServices.addNewProduct(refrigerator);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PostMapping("/vacuumMachine/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody VacuumMachine vacuumMachine, @PathVariable String productType) {
//        productServices.addNewProduct(vacuumMachine);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PostMapping("/washingMachine/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody WashingMachine washingMachine, @PathVariable String productType) {
//        productServices.addNewProduct(washingMachine);
//        return productServices.getProductsByProductType(productType);
//    }
//
//
//    @PostMapping("/smartPhone/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> addNewProduct(@RequestBody SmartPhone smartPhone, @PathVariable String productType) {
//        productServices.addNewProduct(smartPhone);
//        return productServices.getProductsByProductType(productType);
//    }

    ///////////////////////////////===================================================////////////////////////
    @DeleteMapping("/{productId}/{productType}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> removeProduct(@PathVariable Long productId, @PathVariable String productType) {
        productServices.removeProduct(productId);
        return productServices.getProductsByProductType(productType);
    }

    ///////////////////////==============================update Products===================================///////////////////

    @PutMapping("/{productType}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> updateProduct(@RequestBody Product product, @PathVariable String productType) {
        productServices.updateProduct(product);
        return productServices.getProductsByProductType(productType);
    }

//    @PutMapping("/laptop/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody Laptop laptop, @PathVariable String productType) {
//        productServices.updateProduct(laptop);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PutMapping("/desktop/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody Desktop desktop, @PathVariable String productType) {
//        productServices.updateProduct(desktop);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PutMapping("/gamingConsole/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody GamingConsole gamingConsole, @PathVariable String productType) {
//        productServices.updateProduct(gamingConsole);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PutMapping("/tv/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody TV tv, @PathVariable String productType) {
//        productServices.updateProduct(tv);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PutMapping("/refrigerator/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody Refrigerator refrigerator, @PathVariable String productType) {
//        productServices.updateProduct(refrigerator);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PutMapping("/vacuumMachine/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody VacuumMachine vacuumMachine, @PathVariable String productType) {
//        productServices.updateProduct(vacuumMachine);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PutMapping("/washingMachine/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody WashingMachine washingMachine, @PathVariable String productType) {
//        productServices.updateProduct(washingMachine);
//        return productServices.getProductsByProductType(productType);
//    }
//
//    @PutMapping("/smartPhone/{productType}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> updateProduct(@RequestBody SmartPhone smartPhone, @PathVariable String productType) {
//        productServices.updateProduct(smartPhone);
//        return productServices.getProductsByProductType(productType);
//    }
    /////////////////////////===================productType filtering by productType===============================///////////////////////////////

    @GetMapping("/productType/{productType}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByProductType(@PathVariable String productType) {
        return productServices.getProductsByProductType(productType);
    }

    ///////////////////////=========================price sorting================================///////////////////////////////

//    @GetMapping("/filter/{productType}")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//    public ResponseEntity<List<Product>> getProductsByFilter(@RequestParam double maxPrice,
//                                                             @RequestParam double minPrice,
//                                                             @RequestParam int stars,
//                                                             @RequestParam boolean inStock, @PathVariable String productType) {
////        return productServices.getProductsByFilter(productFilteringRequest, productType);
////        System.out.println(maxPrice + " " + minPrice + " " + stars + " " + inStock);
//        return null;
//    }

//TESTINGTESTINGTESING
    @GetMapping("/filter/{productType}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Product>> getProductsByFilter(ProductFilteringRequest productFilteringRequest, @PathVariable String productType){
        return productServices.getProductsByFilter(productFilteringRequest, productType);
    }


    @GetMapping("/filterPrice/Acs/{productType}/{min}/{max}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByPriceAcs(@PathVariable String productType, @PathVariable double min, @PathVariable double max) {
        return productServices.getProductByProductTypeAndPriceAcs(productType, min, max);
    }

    @GetMapping("/filterPrice/Desc/{productType}/{min}/{max}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProductsByPriceDesc(@PathVariable String productType, @PathVariable double min, @PathVariable double max) {
        return productServices.getProductByProductTypeAndPriceDesc(productType, min, max);
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

    /////////////////////////========================filtering by given stars number=================================///////////////////////////////
//    @GetMapping("/filterRating/{productType}/{rating}")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRating(@PathVariable String productType, @PathVariable double rating) {
//        return productServices.getAllProductByProductTypeAndRating(productType, rating);
//    }

    /////////////////////////========================in stoke filtering=================================///////////////////////////////
//    @GetMapping("/filterInStock/{productType}")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<List<Product>> getAllProductByProductTypeAndInStock(@PathVariable String productType) {
//        return productServices.getAllProductByProductTypeAndInStock(productType);
//    }

    /////////////////////////========================searchBar filtering=================================///////////////////////////////
    @GetMapping("/filterKeyWord/{keyWord}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getAllProductByKeyWord(@PathVariable String keyWord) {
        return productServices.getAllProductByKeyWord(keyWord);
    }
}
