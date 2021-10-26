package com.sleepcoders.valhalla.models.products.homeappliances;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("homeapplainces-refrigerator")
@JsonTypeName("refrigerator")
public class Refrigerator extends HomeAppliances {

    private int doorNumber;
    private int drawerNumber;
    private boolean iceCrusher;
    private boolean waterCooler;
    private String size;

    public Refrigerator() {
    }

    public Refrigerator(int quantity, double price, double weight, String name, String description, String model, String brand, String color, int powerConsumption, int yearOfProduction, List<String> imageUrlList, int doorNumber, int drawerNumber, boolean iceCrusher, boolean waterCooler, String size) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.doorNumber = doorNumber;
        this.drawerNumber = drawerNumber;
        this.iceCrusher = iceCrusher;
        this.waterCooler = waterCooler;
        this.size = size;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public int getDrawerNumber() {
        return drawerNumber;
    }

    public void setDrawerNumber(int drawerNumber) {
        this.drawerNumber = drawerNumber;
    }

    public boolean isIceCrusher() {
        return iceCrusher;
    }

    public void setIceCrusher(boolean iceCrusher) {
        this.iceCrusher = iceCrusher;
    }

    public boolean isWaterCooler() {
        return waterCooler;
    }

    public void setWaterCooler(boolean waterCooler) {
        this.waterCooler = waterCooler;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
