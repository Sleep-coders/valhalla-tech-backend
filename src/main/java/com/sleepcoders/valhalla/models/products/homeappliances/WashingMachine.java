package com.sleepcoders.valhalla.models.products.homeappliances;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("homeapplainces-washingmachine")
@JsonTypeName("washing")
public class WashingMachine extends HomeAppliances {
    private int capacity;

    public WashingMachine() {
    }

    public WashingMachine(int quantity, double price, double weight, String name, String description, String model, String brand, String color, int powerConsumption, int yearOfProduction, List<String> imageUrlList, int capacity) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
