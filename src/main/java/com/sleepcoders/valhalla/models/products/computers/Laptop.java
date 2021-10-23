package com.sleepcoders.valhalla.models.products.computers;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("computer-laptop")
public class Laptop extends Computer {

    private String panelSize;

    public Laptop() {

    }

    public Laptop(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, String yearOfProduction, List<String> imageUrlList, String cpu, String ram, String storage, String gpu, String panelSize) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList, cpu, ram, storage, gpu);
        this.panelSize = panelSize;
    }
}
