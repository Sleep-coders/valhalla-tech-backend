package com.sleepcoders.valhalla.models.products.entertainment;

import com.sleepcoders.valhalla.models.products.Product;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Entertainment extends Product {

    public Entertainment() {
    }

    public Entertainment(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, String yearOfProduction, List<String> imageUrlList) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
    }
}
