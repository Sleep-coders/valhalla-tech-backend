package com.sleepcoders.valhalla.models.products.homeappliances;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("homeapplainces-washingmachine")
public class WashingMachine extends HomeAppliances {
    private String capacity;

    public WashingMachine() {
    }

    public WashingMachine(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, String yearOfProduction, List<String> imageUrlList, String capacity) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.capacity = capacity;
    }
}
