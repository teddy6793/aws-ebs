package com.tien.web_shop_online.entities;


import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "tbl_feedback")
public class Feedback {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    private String content;
    private Integer rate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    public Feedback(){

    }

    public Feedback(Customer customerId, Product productId, String content, Integer rate, Date modifiedDate) {
        this.customerId = customerId;
        this.productId = productId;
        this.content = content;
        this.rate = rate;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "customerId=" + customerId +
                ", productId=" + productId +
                ", content='" + content + '\'' +
                ", rate=" + rate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
