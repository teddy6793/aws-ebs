package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Order;
import com.tien.web_shop_online.entities.OrderDetails;
import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.keys.OrderDetailsKey;
import com.tien.web_shop_online.repositories.OrderDetailsRepository;
import com.tien.web_shop_online.repositories.OrderRepository;
import com.tien.web_shop_online.repositories.ProductRepository;
import com.tien.web_shop_online.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderImplement implements OrderService {

    @Autowired
    private OrderRepository rpOrder;

    @Autowired
    private OrderDetailsRepository rpOrderDetails;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Order> findAllOrderProccessing() {
        return rpOrder.findAllByStatus(0);
    }

    @Override
    public List<Order> findAllOrderDelivering() {
        return rpOrder.findAllByStatus(1);
    }

    @Override
    public List<Order> findAllOrderDeliveried() {
        return rpOrder.findAllByStatus(2);
    }

    @Override
    public List<Order> findAllOrderCancelled() {
        return rpOrder.findAllByStatus(3);
    }

    @Override
    public List<Order> findAll() {
        return rpOrder.findAll();
    }

    @Override
    public Order getById(Integer id) {
        return rpOrder.getById(id);
    }

    @Override
    public Optional<Order> findOrderByCustomerAndStatus(Customer customer, Integer status) {
        return rpOrder.findOrderByCustomerIdAndStatus(customer, status);
    }

    @Override
    public Optional<OrderDetails> findOrderDetailsByProductIdAndOrderId(Integer productId, Integer orderId) {
        Product product = productRepository.getById(productId);
        Order order = rpOrder.getById(orderId);
        Optional<OrderDetails> found = rpOrderDetails.findOrderDetailsByProductIdAndOrderId(product,order);
        return found;
    }

    @Override
    public void saveOrder(Order order) {
        rpOrder.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        rpOrder.deleteById(id);
    }

    @Override
    public List<Order> findByCustomerId(Customer customer) {
        return rpOrder.findAllByCustomerId(customer);
    }

    @Override
    public void saveItem(OrderDetails orderDetails) {
        rpOrderDetails.save(orderDetails);
    }

    @Override
    public void deleteItem(OrderDetailsKey id) {
        rpOrderDetails.deleteById(id);
    }

    @Override
    public List<OrderDetails> findByOrderId(Integer id) {
        Order o = rpOrder.getById(id);
        return rpOrderDetails.findAllByOrderId(o);
    }

    @Override
    public List<Order> findAllOrderByOrderDateBetween(Date start, Date end) {
        return rpOrder.findAllByOrderDateBetween(start, end);
    }

    @Override
    public List<Order> findAllOrderByOrderDate(Date date) {
        return rpOrder.findAllByOrderDate(date);
    }
}
