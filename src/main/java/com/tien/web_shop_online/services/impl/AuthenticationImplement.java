package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.repositories.CustomerRepository;
import com.tien.web_shop_online.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthenticationImplement implements AuthenticationService {

    @Autowired
    private CustomerRepository rp;

    @Override
    public Boolean isRightInformation(String username, String password) {
        Optional<Customer> user = rp.findCustomerByEmailAndPassword(username,password);
        return user.isPresent()? true : false;
    }
}
