package com.tien.web_shop_online.repositories;

import com.tien.web_shop_online.entities.Order;
import com.tien.web_shop_online.entities.OrderDetails;
import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.keys.OrderDetailsKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsKey> {
    List<OrderDetails> findAllByOrderId(Order orderId);
    Optional<OrderDetails> findOrderDetailsByProductIdAndOrderId(Product productId, Order orderId);
}
