package com.sleepcoders.valhalla.models.user_purchases_request;

public class PurchaseRequest {

    private Long userId;
    private Long[] productsIds;


    public PurchaseRequest() {
    }

    public PurchaseRequest(Long userId, Long[] productsIds) {
        this.userId = userId;
        this.productsIds = productsIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long[] getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(Long[] productsIds) {
        this.productsIds = productsIds;
    }
}

