package com.sleepcoders.valhalla.models.products.entertainment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("entertainment-tv")
public class TV extends Entertainment{
    private String panelSize;
    private String panelType;
    private String panelResolution;
    private boolean smart;

    public TV() {
    }

    public TV(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, String yearOfProduction, List<String> imageUrlList, String panelSize, String panelType, String panelResolution, boolean smart) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.panelSize = panelSize;
        this.panelType = panelType;
        this.panelResolution = panelResolution;
        this.smart = smart;
    }
}
