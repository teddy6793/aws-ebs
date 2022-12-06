package com.tien.web_shop_online.services;

import com.tien.web_shop_online.entities.Address;
import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.CustomerAddress;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    void saveAddress(Address address);
    List<Address> findAllAddress();
    List<CustomerAddress> findAllAddressByCustomerId(Customer id);
    void deleteAddressById(Integer id);
    void deleteCustomerAddress(Address aId, Customer cId);
    Optional<Address> findAddressById(Integer id);
    List<Address> findAddressesByAddressLine(String addressLine);
    List<Address> findAddressesByDistrict(String district);
    List<Address> findAddressesByPostalCode(String code);
    void saveAddressOfCustomer(CustomerAddress address);
    void deleteAddressOfCustomer(Integer idAddress, Integer idCustomer);
}
