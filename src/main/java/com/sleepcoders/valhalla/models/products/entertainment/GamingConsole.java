package com.sleepcoders.valhalla.models.products.entertainment;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("entertainment-gamingConsole")
@JsonTypeName("entertainment-gamingConsole")
public class GamingConsole extends Entertainment{
    private int storage;
    private boolean vrSupport;

    public GamingConsole() {

    }

    public GamingConsole(int quantity, double price, double weight, String name, String description, String model, String brand, String color, int powerConsumption, int yearOfProduction, List<String> imageUrlList, int storage, boolean vrSupport) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.storage = storage;
        this.vrSupport = vrSupport;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public boolean isVrSupport() {
        return vrSupport;
    }

    public void setVrSupport(boolean vrSupport) {
        this.vrSupport = vrSupport;
    }

}
