package com.sleepcoders.valhalla.models.user_purchases_request;

import java.util.Map;

public class PurchaseRequest {

    private Long userId;
    private Map<String, Integer> productIdProductQuantity;
//    private Long[] productsIds;
//    private Long[] productsQuantity;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Long userId, Map<String, Integer> productIdProductQuantity) {
        this.userId = userId;
        this.productIdProductQuantity = productIdProductQuantity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<String, Integer> getProductIdProductQuantity() {
        return productIdProductQuantity;
    }

    public void setProductIdProductQuantity(Map<String, Integer> productIdProductQuantity) {
        this.productIdProductQuantity = productIdProductQuantity;
    }

//    public Long[] getProductsIds() {
//        return productsIds;
//    }
//
//    public void setProductsIds(Long[] productsIds) {
//        this.productsIds = productsIds;
//    }
//
//    public Long[] getProductsQuantity() {
//        return productsQuantity;
//    }
//
//    public void setProductsQuantity(Long[] productsQuantity) {
//        this.productsQuantity = productsQuantity;
//    }
}

