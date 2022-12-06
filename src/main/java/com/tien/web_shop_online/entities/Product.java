package com.tien.web_shop_online.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    private Double standCost;

    private Double listPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private ProductCategory categoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_brand")
    private ProductBrand  productBrand;

    private String thumbnailPhoto;

    private Double rate;

    private Date modifiedDate;

    private String description;

    private Integer quantity;

    public Product(){
    }

    public Product(String name, Double standCost, Double listPrice, ProductCategory categoryId, ProductBrand productBrand, String thumbnailPhoto, Double rate, Date modifiedDate, String description) {
        this.name = name;
        this.standCost = standCost;
        this.listPrice = listPrice;
        this.categoryId = categoryId;
        this.productBrand = productBrand;
        this.thumbnailPhoto = thumbnailPhoto;
        this.rate = rate;
        this.modifiedDate = modifiedDate;
        this.description = description;
    }

    public Product(Integer id, String name, Double standCost, Double listPrice, ProductCategory categoryId, ProductBrand productBrand, String thumbnailPhoto, Double rate, Date modifiedDate) {
        this.id = id;
        this.name = name;
        this.standCost = standCost;
        this.listPrice = listPrice;
        this.categoryId = categoryId;
        this.productBrand = productBrand;
        this.thumbnailPhoto = thumbnailPhoto;
        this.rate = rate;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", standCost=" + standCost +
                ", listPrice=" + listPrice +
                ", categoryId=" + categoryId +
                ", productBrand=" + productBrand +
                ", thumbnailPhoto='" + thumbnailPhoto + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public void setCategoryId(ProductCategory categoryId) {
        this.categoryId = categoryId;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }

    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public ProductCategory getCategoryId() {
        return categoryId;
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

    public Double getStandCost() {
        return standCost;
    }

    public void setStandCost(Double standCost) {
        this.standCost = standCost;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public String getThumbnailPhoto() {
        return thumbnailPhoto;
    }

    public void setThumbnailPhoto(String thumbnailPhoto) {
        this.thumbnailPhoto = thumbnailPhoto;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
