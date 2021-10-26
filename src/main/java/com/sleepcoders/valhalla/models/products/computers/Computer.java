package com.sleepcoders.valhalla.models.products.computers;
import com.sleepcoders.valhalla.models.products.Product;

import javax.persistence.Entity;
import java.util.List;

@Entity
public abstract class Computer extends Product {

    private String cpu;
    private String ram;
    private int storage;
    private String gpu;

    public Computer() {

    }

    public Computer(int quantity, double price, double weight, String name, String description, String model, String brand, String color, int powerConsumption, int yearOfProduction, List<String> imageUrlList, String cpu, String ram, int storage, String gpu) {
        super(quantity, price, weight, name, description, model, brand, color, powerConsumption, yearOfProduction, imageUrlList);
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
}
