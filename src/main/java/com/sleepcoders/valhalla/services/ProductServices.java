package com.sleepcoders.valhalla.services;

import com.sleepcoders.valhalla.models.product_filtering_request.ProductFilteringRequest;
import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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

    public ResponseEntity<Product> getProductById(Long productId) {
        Product product = productRepo.getById(productId);
        return ResponseEntity.ok(product);
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
    /////////////////////////===================productType filtering by productType===============================////////////////////////////

    public ResponseEntity<List<Product>> getProductsByFilter(ProductFilteringRequest productFilteringRequest, String productType) {
        double min = productFilteringRequest.getMinPrice();
        double max = productFilteringRequest.getMaxPrice();
        int rating = productFilteringRequest.getStars();
        boolean inStock = productFilteringRequest.isInStock();
        List<Product> productList;

        if (inStock) {
            productList = productRepo.findAllByProductTypeAndFilterParamsInStock(productType, min, max, rating).orElse(new ArrayList<>());
            return ResponseEntity.ok(productList);
        }
        productList = productRepo.findAllByProductTypeAndFilterParams(productType, min, max, rating).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getProductsByProductType(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }

    ////////////////////========================rate sorting==========================////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingAsc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> (int) (o1.getRating() - o2.getRating()));
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndRatingDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> (int) (o2.getRating() - o1.getRating()));
        return ResponseEntity.ok(productList);
    }

    ////////////////////========================model sorting==========================////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelAcs(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> {
            if (o1.getModel().equals(o2.getModel()))
                return Integer.compare(o1.getYearOfProduction(), o2.getYearOfProduction());
            else
                return o1.getModel().compareTo(o2.getModel());
        });
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndModelDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> {
            if (o2.getModel().equals(o1.getModel()))
                return Integer.compare(o2.getYearOfProduction(), o1.getYearOfProduction());
            else
                return o2.getModel().compareTo(o1.getModel());
        });
        return ResponseEntity.ok(productList);
    }

    ////////////////////========================name sorting==========================////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameAcs(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> {
            if (o1.getName().equals(o2.getName()))
                return Integer.compare(o1.getYearOfProduction(), o2.getYearOfProduction());
            else
                return o1.getName().compareTo(o2.getName());
        });
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getAllProductByProductTypeAndNameDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> {
            if (o2.getName().equals(o1.getName()))
                return Integer.compare(o1.getYearOfProduction(), o2.getYearOfProduction());
            else
                return o2.getName().compareTo(o1.getName());
        });
        return ResponseEntity.ok(productList);
    }

////////////////////========================price sorting==========================////////////////////////////

    public ResponseEntity<List<Product>> getProductByProductTypeAndPriceAcs(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getProductByProductTypeAndPriceDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
        return ResponseEntity.ok(productList);
    }

    ////////////////////========================yearOfProduction sorting==========================////////////////////////////

    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionAcs(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort(Comparator.comparingInt(Product::getYearOfProduction));
        return ResponseEntity.ok(productList);
    }

    public ResponseEntity<List<Product>> getProductByProductTypeAndYearOfProductionDesc(String productType) {
        List<Product> productList = productRepo.findAllByProductType(productType).orElse(new ArrayList<>());
        productList.sort((o1, o2) -> o2.getYearOfProduction() - o1.getYearOfProduction());
        return ResponseEntity.ok(productList);
    }

    /////////////////////////========================searchBar filtering=================================///////////////////////////////
    public ResponseEntity<List<Product>> getAllProductByKeyWord(String keyWord) {
        List<Product> productList = productRepo.findAllBySearchKeyWord(keyWord).orElse(new ArrayList<>());
        return ResponseEntity.ok(productList);
    }
}
