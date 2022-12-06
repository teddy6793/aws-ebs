package com.tien.web_shop_online.entities.keys;

import java.io.Serializable;
import java.util.Objects;

public class CustomerAddressKey implements Serializable {
    private Integer customerId;
    private Integer addressId;

    public CustomerAddressKey() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public CustomerAddressKey(Integer customerId, Integer addressId) {
        this.customerId = customerId;
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAddressKey that = (CustomerAddressKey) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, addressId);
    }
}
