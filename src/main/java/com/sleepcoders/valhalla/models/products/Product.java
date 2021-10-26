package com.sleepcoders.valhalla.models.products;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sleepcoders.valhalla.models.products.computers.Desktop;
import com.sleepcoders.valhalla.models.products.computers.Laptop;
import com.sleepcoders.valhalla.models.products.entertainment.GamingConsole;
import com.sleepcoders.valhalla.models.products.entertainment.TV;
import com.sleepcoders.valhalla.models.products.homeappliances.Refrigerator;
import com.sleepcoders.valhalla.models.products.homeappliances.VacuumMachine;
import com.sleepcoders.valhalla.models.products.homeappliances.WashingMachine;
import com.sleepcoders.valhalla.models.products.smartphones.SmartPhone;
import com.sleepcoders.valhalla.models.reviews.ProductReview;
import com.sleepcoders.valhalla.models.users.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Laptop.class, name = "laptop"),
        @JsonSubTypes.Type(value = Desktop.class, name = "desktop"),
        @JsonSubTypes.Type(value = GamingConsole.class, name = "gamingConsole"),
        @JsonSubTypes.Type(value = TV.class, name = "tv"),
        @JsonSubTypes.Type(value = Refrigerator.class, name = "refrigerator"),
        @JsonSubTypes.Type(value = VacuumMachine.class, name = "vacuum"),
        @JsonSubTypes.Type(value = WashingMachine.class, name = "washing"),
        @JsonSubTypes.Type(value = SmartPhone.class, name = "smartphone")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantity;
    private double price;
    private double rating;
    private double weight;

    private String name;
    private String description;
    private String model;
    private String brand;
    private String color;
    private String powerConsumption;
    private int yearOfProduction;

    @OneToMany(mappedBy = "product")
    private Set<ProductReview> productReviewList;

    @ManyToMany(mappedBy = "productList")
    private Set<User> users;

    @ElementCollection
    @CollectionTable(name = "products_images_url", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "product_img_url")
    private List<String> imageUrlList;

    /////////////////////////////////////////////////////////////////////////////////////


    public Product() {
    }

    public Product(int quantity, double price, double weight, String name, String description, String model, String brand, String color, String powerConsumption, int yearOfProduction, List<String> imageUrlList) {
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.name = name;
        this.description = description;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.powerConsumption = powerConsumption;
        this.yearOfProduction = yearOfProduction;
        this.imageUrlList = imageUrlList;
        users = new HashSet<>();
    }


    /////////////////////////////////////////////////////////////////////////////////////


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Set<ProductReview> getReviewList() {
        return productReviewList;
    }

    public void setReviewList(Set<ProductReview> productReviewList) {
        this.productReviewList = productReviewList;
    }

    public boolean isInStock() {
        return quantity > 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(String powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}