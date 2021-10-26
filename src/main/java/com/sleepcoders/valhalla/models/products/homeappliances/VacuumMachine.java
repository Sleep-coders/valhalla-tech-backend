package com.sleepcoders.valhalla.models.products.homeappliances;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("homeapplainces-vacuummachine")
@JsonTypeName("vacuum")
public class VacuumMachine extends HomeAppliances {
    private String airFlow;
    private String noiseLevel;

    public VacuumMachine() {
    }

    public VacuumMachine(int quantity, double price, double weight, String name, String description, String model, String brand, String color, int powerConsumption, int yearOfProduction, List<String> imageUrlList, String airFlow, String noiseLevel) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.airFlow = airFlow;
        this.noiseLevel = noiseLevel;
    }

    public String getAirFlow() {
        return airFlow;
    }

    public void setAirFlow(String airFlow) {
        this.airFlow = airFlow;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }
}
