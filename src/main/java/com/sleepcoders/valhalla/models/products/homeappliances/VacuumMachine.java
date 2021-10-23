package com.sleepcoders.valhalla.models.products.homeappliances;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("homeapplainces-vacuummachine")
public class VacuumMachine extends HomeApplainces {
    private String airFlow;
    private String noiseLevel;

    public VacuumMachine() {
    }

    public VacuumMachine(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, String yearOfProduction, List<String> imageUrlList, String airFlow, String noiseLevel) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.airFlow = airFlow;
        this.noiseLevel = noiseLevel;
    }
}
