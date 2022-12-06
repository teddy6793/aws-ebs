package com.tien.web_shop_online.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="tbl_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String addressLine;

    private String province;

    private String district;

    private String postalCode;

    private Date modifiedDate;

    public Address() {
    }

    public Address(Integer id, String addressLine, String province, String district, String postalCode, Date modifiedDate) {
        this.id = id;
        this.addressLine = addressLine;
        this.province = province;
        this.district = district;
        this.postalCode = postalCode;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressLine='" + addressLine + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
