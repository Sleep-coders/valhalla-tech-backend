package com.sleepcoders.valhalla.models.products.smartphones;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sleepcoders.valhalla.models.products.computers.Computer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("smartphone")
@JsonTypeName("smartphone")
public class SmartPhone extends Computer {

    private String camera;

    public SmartPhone() {
    }

    public SmartPhone(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, int yearOfProduction, List<String> imageUrlList, String cpu, String ram, String storage, String gpu, String camera) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList, cpu, ram, storage, gpu);
        this.camera = camera;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }
}
