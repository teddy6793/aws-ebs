package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.entities.Address;
import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.CustomerAddress;
import com.tien.web_shop_online.entities.keys.CustomerAddressKey;
import com.tien.web_shop_online.repositories.AddressRepository;
import com.tien.web_shop_online.repositories.CustomerAddressRepository;
import com.tien.web_shop_online.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressImplement implements AddressService {

    @Autowired
    private AddressRepository rpAddress;

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private CustomerAddressRepository rpAddresOfCustomer;

    @Override
    public void saveAddress(Address address) {
        rpAddress.save(address);
    }

    @Override
    public List<Address> findAllAddress() {
        return rpAddress.findAll();
    }

    @Override
    public List<CustomerAddress> findAllAddressByCustomerId(Customer id) {
        return customerAddressRepository.findAllByCustomerId(id);
    }

    @Override
    public void deleteAddressById(Integer id) {
        rpAddress.deleteById(id);
    }

    @Override
    public void deleteCustomerAddress(Address aId, Customer cId) {
        long a =  customerAddressRepository.deleteCustomerAddressByAddressIdAndCustomerId(aId, cId);
    }

    @Override
    public Optional<Address> findAddressById(Integer id) {
        return rpAddress.findById(id);
    }

    @Override
    public List<Address> findAddressesByAddressLine(String addressLine) {
        return rpAddress.findAddressesByAddressLine(addressLine);
    }

    @Override
    public List<Address> findAddressesByDistrict(String district) {
        return rpAddress.findAddressesByDistrict(district);
    }

    @Override
    public List<Address> findAddressesByPostalCode(String code) {
        return rpAddress.findAddressesByPostalCode(code);
    }

    @Override
    public void saveAddressOfCustomer(CustomerAddress address) {
        rpAddresOfCustomer.save(address);
    }

    @Override
    public void deleteAddressOfCustomer(Integer idAddress, Integer idCustomer) {
        CustomerAddressKey key = new CustomerAddressKey();
        key.setAddressId(idAddress);
        key.setCustomerId(idCustomer);
        rpAddresOfCustomer.deleteById(key);
    }
}
