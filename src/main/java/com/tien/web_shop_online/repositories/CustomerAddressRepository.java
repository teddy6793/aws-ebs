package com.tien.web_shop_online.repositories;

import com.tien.web_shop_online.entities.Address;
import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.CustomerAddress;
import com.tien.web_shop_online.entities.keys.CustomerAddressKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, CustomerAddressKey> {
    List<CustomerAddress> findAllByCustomerId(Customer id);
    long deleteCustomerAddressByAddressIdAndCustomerId(Address addressId, Customer customerId);
}
