package com.tien.web_shop_online.repositories;

import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findCustomersByFirstName(String name);

    List<Customer> findCustomersByRole(Role role);

    Optional<Customer> findCustomerByEmailAndPassword(String email, String password);

    Customer getCustomerByEmailAndAndPassword(String email, String password);

    Customer getCustomerByEmail(String email);

    List<Customer> findTop6ByRole(Role role);
}
