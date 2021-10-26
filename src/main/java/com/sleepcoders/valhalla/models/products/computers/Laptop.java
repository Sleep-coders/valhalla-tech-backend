package com.sleepcoders.valhalla.models.products.computers;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("computer-laptop")
@JsonTypeName("laptop")
public class Laptop extends Computer {

    private String panelSize;

    public Laptop() {

    }

    public Laptop(int quantity, double price, double weight, String name, String description, String model, String brand, String color, int powerConsumption, int yearOfProduction, List<String> imageUrlList, String cpu, String ram, int storage, String gpu, String panelSize) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList, cpu, ram, storage, gpu);
        this.panelSize = panelSize;
    }

    public String getPanelSize() {
        return panelSize;
    }

    public void setPanelSize(String panelSize) {
        this.panelSize = panelSize;
    }
}
