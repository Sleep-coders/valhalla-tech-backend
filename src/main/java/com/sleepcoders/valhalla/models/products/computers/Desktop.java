package com.sleepcoders.valhalla.models.products.computers;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("computer-desktop")
@JsonTypeName("desktop")
public class Desktop extends Computer{

    public Desktop() {
    }

    public Desktop(int quantity, double price, double weight, String name, String description, String model, String brand, String color, int powerConsumption, int yearOfProduction, List<String> imageUrlList, String cpu, String ram, String storage, String gpu) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList, cpu, ram, storage, gpu);
    }


}
