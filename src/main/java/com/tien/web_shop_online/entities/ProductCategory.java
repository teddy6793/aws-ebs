package com.tien.web_shop_online.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date modifiedDate;

    public ProductCategory() {
    }

    public ProductCategory(String name, Date modifiedDate) {
        this.name = name;
        this.modifiedDate = modifiedDate;
    }

    public ProductCategory(Integer id, String name, Date modifiedDate) {
        this.id = id;
        this.name = name;
        this.modifiedDate = modifiedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
