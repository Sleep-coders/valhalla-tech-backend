package com.sleepcoders.valhalla.models.products.smartphones;

import com.sleepcoders.valhalla.models.products.computers.Computer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("smartphone")
public class SmartPhone extends Computer {

    private String camera;

    public SmartPhone() {
    }

    public SmartPhone(String name, String description, String brand, String color, ArrayList<String> imageUrlList, double price, String cpu, String ram, String storage, String gpu, String powerConsumption, String camera) {
        super(name, description, brand, color, imageUrlList, price, cpu, ram, storage, gpu, powerConsumption);
        this.camera = camera;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }
}
