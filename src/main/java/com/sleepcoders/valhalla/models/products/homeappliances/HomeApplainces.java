package com.sleepcoders.valhalla.models.products.homeappliances;

import com.sleepcoders.valhalla.models.products.Product;

import javax.persistence.Entity;
import java.util.List;

@Entity
public abstract class HomeApplainces extends Product {

    public HomeApplainces() {
    }

    public HomeApplainces(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, String yearOfProduction, List<String> imageUrlList) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, user, imageUrlList);
    }
}
