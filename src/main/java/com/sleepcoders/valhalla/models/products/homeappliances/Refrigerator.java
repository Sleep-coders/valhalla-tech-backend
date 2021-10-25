package com.sleepcoders.valhalla.models.products.homeappliances;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("homeapplainces-refrigerator")
public class Refrigerator extends HomeAppliances {

    private int doorNumber;
    private int drawerNumber;
    private boolean iceCrusher;
    private boolean waterCooler;
    private String size;

    public Refrigerator() {
    }

    public Refrigerator(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, int yearOfProduction, List<String> imageUrlList, int doorNumber, int drawerNumber, boolean iceCrusher, boolean waterCooler, String size) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.doorNumber = doorNumber;
        this.drawerNumber = drawerNumber;
        this.iceCrusher = iceCrusher;
        this.waterCooler = waterCooler;
        this.size = size;
    }
}
