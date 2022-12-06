package com.tien.web_shop_online.services;


import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Role;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void saveCustomer(Customer customer);

    Optional<Customer> findCustomerById(Integer id);

    List<Customer> findAllCustomer();

    void deleteCustomerById(Integer id);

    List<Customer> findCustomerByRole(Role role);

    Customer getCustomerById(Integer id);

    Customer getCustomerByEmailAndPassword(String email, String password);

    Customer getCustomerByEmail(String email);

    List<Customer> findTop5Customer();
}
