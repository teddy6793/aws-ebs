package com.tien.web_shop_online.services;



import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Order;
import com.tien.web_shop_online.entities.OrderDetails;
import com.tien.web_shop_online.entities.keys.OrderDetailsKey;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAllOrderProccessing();

    List<Order> findAllOrderDelivering();

    List<Order> findAllOrderDeliveried();

    List<Order> findAllOrderCancelled();

    List<Order> findAll();

    List<OrderDetails> findByOrderId(Integer id);

    List<Order> findAllOrderByOrderDateBetween(Date start, Date end);

    List<Order> findAllOrderByOrderDate(Date date);

    List<Order> findByCustomerId(Customer customer);

    Order getById(Integer id);

    Optional<Order> findOrderByCustomerAndStatus(Customer customer, Integer status);

    Optional<OrderDetails> findOrderDetailsByProductIdAndOrderId(Integer productId, Integer orderId);

    void saveOrder(Order order);

    void deleteOrder(Integer id);

    void saveItem(OrderDetails orderDetails);

    void deleteItem(OrderDetailsKey id);

}
