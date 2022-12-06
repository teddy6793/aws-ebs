package com.tien.web_shop_online.entities.keys;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailsKey implements Serializable {
    private Integer productId;
    private Integer orderId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderDetailsKey(Integer productId, Integer orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public OrderDetailsKey(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsKey that = (OrderDetailsKey) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }
}
