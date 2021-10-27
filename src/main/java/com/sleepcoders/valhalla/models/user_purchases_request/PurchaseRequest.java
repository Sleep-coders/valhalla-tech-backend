package com.sleepcoders.valhalla.models.user_purchases_request;

import java.util.Map;

public class PurchaseRequest {

    private Long userId;
//    private Map<String, Integer> productIdProductQuantity;
    private Long[] productsIds;
    private int[] productsQuantity;

    public PurchaseRequest() {
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PurchaseRequest(Long[] productsIds, int[] productsQuantity) {
        this.productsIds = productsIds;
        this.productsQuantity = productsQuantity;
    }

    public Long[] getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(Long[] productsIds) {
        this.productsIds = productsIds;
    }

    public int[] getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(int[] productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
}

