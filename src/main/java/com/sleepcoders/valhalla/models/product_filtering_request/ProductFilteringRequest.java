package com.sleepcoders.valhalla.models.product_filtering_request;

public class ProductFilteringRequest {
    private double maxPrice;
    private double minPrice;
    private int stars;
    private boolean inStock;

    public ProductFilteringRequest() {
    }

    public ProductFilteringRequest(double maxPrice, double minPrice, int stars, boolean inStock) {
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.stars = stars;
        this.inStock = inStock;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
