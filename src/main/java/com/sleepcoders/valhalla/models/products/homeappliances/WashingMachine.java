package com.sleepcoders.valhalla.models.products.homeappliances;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("homeapplainces-washingmachine")
@JsonTypeName("washing")
public class WashingMachine extends HomeAppliances {
    private String capacity;

    public WashingMachine() {
    }

    public WashingMachine(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, int yearOfProduction, List<String> imageUrlList, String capacity) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
