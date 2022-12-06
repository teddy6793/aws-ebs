package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Role;
import com.tien.web_shop_online.repositories.CustomerRepository;
import com.tien.web_shop_online.repositories.RoleRepository;
import com.tien.web_shop_online.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerImplement implements CustomerService {

    @Autowired
    private CustomerRepository rp;

    Integer CUSTOMER_ROLE = 3;
    Integer STAFF_ROLE = 2;
    Integer ADMIN_ROLE = 1;

    @Autowired
    private RoleRepository rpRole;

    @Override
    public void saveCustomer(Customer customer) {
        rp.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerById(Integer id) {
        return rp.findById(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return rp.findAll();
    }

    @Override
    public void deleteCustomerById(Integer id) {
        rp.deleteById(id);
    }

    @Override
    public List<Customer> findCustomerByRole(Role role) {
        return rp.findCustomersByRole(role);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return rp.getById(id);
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String password) {
        return rp.getCustomerByEmailAndAndPassword(email,password);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return rp.getCustomerByEmail(email);
    }

    @Override
    public List<Customer> findTop5Customer() {
        Role customerRole = rpRole.getById(CUSTOMER_ROLE);
        return rp.findTop6ByRole(customerRole);
    }
}
