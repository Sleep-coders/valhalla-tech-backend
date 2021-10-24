package com.sleepcoders.valhalla.controllers;

import com.sleepcoders.valhalla.models.products.Product;
import com.sleepcoders.valhalla.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

}
