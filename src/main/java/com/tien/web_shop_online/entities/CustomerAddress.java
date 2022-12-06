package com.tien.web_shop_online.entities;

import com.tien.web_shop_online.entities.keys.CustomerAddressKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_customer_address")
@IdClass(CustomerAddressKey.class)
public class CustomerAddress {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address addressId;

    private String typeAddress;

    private Date modifiedDate;

    public CustomerAddress() {

    }

    public CustomerAddress(Customer customerId, Address addressId, String typeAddress, Date modifiedDate) {
        this.customerId = customerId;
        this.addressId = addressId;
        this.typeAddress = typeAddress;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "customerId=" + customerId +
                ", addressId=" + addressId +
                ", typeAddress='" + typeAddress + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public String getTypeAddress() {
        return typeAddress;
    }

    public void setTypeAddress(String typeAddress) {
        this.typeAddress = typeAddress;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}
