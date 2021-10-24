package com.sleepcoders.valhalla.models.relations;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductReviewKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "product_id")
    Long productId;

    public ProductReviewKey(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductReviewKey)) return false;
        ProductReviewKey that = (ProductReviewKey) o;
        return getUserId().equals(that.getUserId()) && getProductId().equals(that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getProductId());
    }
}
