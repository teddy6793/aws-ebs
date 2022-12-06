package com.tien.web_shop_online.entities;

import com.tien.web_shop_online.entities.keys.OrderDetailsKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_order_details")
@IdClass(OrderDetailsKey.class)
public class OrderDetails {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderId;

    private Integer quantity;
    private Double unitPrice;
    private Double total;
    private Date modifiedDate;

    public OrderDetails() {
    }

    public OrderDetails(Product productId, Order orderId, Integer quantity, Double unitPrice, Double total, Date modifiedDate) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "productId=" + productId +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}
