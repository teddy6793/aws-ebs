package com.tien.web_shop_online.controllers.api;

import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Order;
import com.tien.web_shop_online.entities.OrderDetails;
import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.keys.OrderDetailsKey;
import com.tien.web_shop_online.services.CustomerService;
import com.tien.web_shop_online.services.OrderService;
import com.tien.web_shop_online.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderAPI {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/cart/add_product/{productId}")
    public String addProductToCart(@PathVariable Integer productId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product product = productService.findProductById(productId);
        Integer customerId = (Integer) session.getAttribute("userId");

        if (customerId == null) {
            return "Bạn hãy đăng nhập trước";
        } else {
            Customer customer = customerService.getCustomerById(customerId);
            Optional<Order> orderFound = orderService.findOrderByCustomerAndStatus(customer, -1);
            if (orderFound.isPresent()) { // Đã có giỏ hàng
                Order order = orderFound.get();
                OrderDetails orderDetails = null;
                Optional<OrderDetails> orderDetailsFound = orderService
                        .findOrderDetailsByProductIdAndOrderId(product.getId(), order.getId());
                if (orderDetailsFound.isPresent()) {
                    orderDetails = orderDetailsFound.get();
                    orderDetails.setModifiedDate(new Date());
                    Integer quantity = orderDetails.getQuantity() + 1;
                    orderDetails.setQuantity(quantity);
                    orderDetails.setTotal(orderDetails.getQuantity() * orderDetails.getUnitPrice());
                } else {
                    orderDetails = new OrderDetails();
                    orderDetails.setOrderId(order);
                    orderDetails.setModifiedDate(new Date());
                    orderDetails.setProductId(product);
                    orderDetails.setQuantity(1);
                    orderDetails.setUnitPrice(product.getListPrice());
                    orderDetails.setTotal(orderDetails.getQuantity() * orderDetails.getUnitPrice());
                }
                orderService.saveItem(orderDetails);
                List<OrderDetails> listOrderDetails = orderService.findByOrderId(order.getId());
                double sum = 0;
                for (OrderDetails o : listOrderDetails) {
                    sum += o.getTotal();
                }
                order.setTotalPrice(sum);
                orderService.saveItem(orderDetails);
                orderService.saveOrder(order);
                return "Thêm thành công";
            } else { // Nếu chưa có giỏ hàng mới
                Order order = new Order();
                order.setStatus(-1);
                order.setModifiedDate(new Date());
                order.setCustomerId(customer);

                orderService.saveOrder(order);
                OrderDetails orderDetails = new OrderDetails();

                orderDetails.setOrderId(order);
                orderDetails.setModifiedDate(new Date());
                orderDetails.setProductId(product);
                orderDetails.setQuantity(1);
                orderDetails.setUnitPrice(product.getListPrice());
                orderDetails.setTotal(orderDetails.getQuantity() * orderDetails.getUnitPrice());
                List<OrderDetails> listOrderDetails = orderService.findByOrderId(order.getId());
                double sum = 0;
                for (OrderDetails o : listOrderDetails) {
                    sum += o.getTotal();
                }
                order.setTotalPrice(sum);
                orderService.saveItem(orderDetails);
                orderService.saveOrder(order);
                return "Thêm thành công";
            }
        }
    }

    @RequestMapping("/cart/add_product/{productId}/{quantity}")
    public String addProductToCartAndQuantity(@PathVariable Integer productId, @PathVariable Integer quantity,
                                              HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product product = productService.findProductById(productId);
        Integer customerId = (Integer) session.getAttribute("userId");
        if (customerId == null) {
            return "Bạn hãy đăng nhập trước";
        } else {
            Customer customer = customerService.getCustomerById(customerId);
            Optional<Order> orderFound = orderService.findOrderByCustomerAndStatus(customer, -1);
            if (orderFound.isPresent()) { // Đã có giỏ hàng
                Order order = orderFound.get();
                OrderDetails orderDetails = null;
                Optional<OrderDetails> orderDetailsFound = orderService
                        .findOrderDetailsByProductIdAndOrderId(product.getId(), order.getId());
                if (orderDetailsFound.isPresent()) {
                    orderDetails = orderDetailsFound.get();
                    orderDetails.setModifiedDate(new Date());
                    orderDetails.setQuantity(orderDetails.getQuantity() + quantity);
                    orderDetails.setTotal(orderDetails.getQuantity() * orderDetails.getUnitPrice());
                } else {
                    orderDetails = new OrderDetails();
                    orderDetails.setOrderId(order);
                    orderDetails.setModifiedDate(new Date());
                    orderDetails.setProductId(product);
                    orderDetails.setQuantity(quantity);
                    orderDetails.setUnitPrice(product.getListPrice());
                    orderDetails.setTotal(orderDetails.getQuantity() * orderDetails.getUnitPrice());
                }
                List<OrderDetails> listOrderDetails = orderService.findByOrderId(order.getId());
                double sum = 0;
                for (OrderDetails o : listOrderDetails) {
                    sum += o.getTotal();
                }
                order.setTotalPrice(sum);
                orderService.saveItem(orderDetails);
                orderService.saveOrder(order);
                return "Thêm thành công";
            } else { //Nếu chưa có giỏ hàng mới
                Order order = new Order();
                order.setStatus(-1);
                order.setModifiedDate(new Date());
                order.setCustomerId(customer);

                OrderDetails orderDetails = new OrderDetails();

                orderDetails.setOrderId(order);
                orderDetails.setModifiedDate(new Date());
                orderDetails.setProductId(product);
                orderDetails.setQuantity(1);
                orderDetails.setUnitPrice(product.getListPrice());
                orderDetails.setTotal(orderDetails.getQuantity() * orderDetails.getUnitPrice());
                orderService.saveOrder(order);
                List<OrderDetails> listOrderDetails = orderService.findByOrderId(order.getId());
                double sum = 0;
                for (OrderDetails o : listOrderDetails) {
                    sum += o.getTotal();
                }
                order.setTotalPrice(sum);
                orderService.saveItem(orderDetails);
                orderService.saveOrder(order);

                orderService.saveItem(orderDetails);
                orderService.saveOrder(order);
                return "Thêm thành công";
            }
        }
    }

    @RequestMapping(value = "/cart/delete_product/{orderId}/{productId}")
    public String deleteProductInCart(@PathVariable Integer orderId, @PathVariable Integer productId,
                                      HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product product = productService.findProductById(productId);
        Integer customerId = (Integer) session.getAttribute("userId");
        Customer customer = customerService.getCustomerById(customerId);
        Optional<Order> orderFound = orderService.findOrderByCustomerAndStatus(customer, -1);
        Order order = null;
        if (customerId == null) {
            return "Bạn hãy đăng nhập trước";
        } else {
            if (orderFound.isPresent()) {
                order = orderFound.get();
                OrderDetailsKey orderDetailsKey = new OrderDetailsKey(productId, order.getId());
                orderService.deleteItem(orderDetailsKey);
                List<OrderDetails> listOrderDetails = orderService.findByOrderId(order.getId());
                double sum = 0;
                for (OrderDetails o : listOrderDetails) {
                    sum += o.getTotal();
                }
                order.setTotalPrice(sum);
                orderService.saveOrder(order);
                return customer.getId() + "";
            } else {
                return "Không tìm thấy giỏ hàng";
            }
        }
    }

    @RequestMapping(value = "/update_quantity/{productId}/{orderId}/{quantity}")
    public String updateQuantity(@PathVariable Integer productId, @PathVariable Integer orderId,
                                 @PathVariable Integer quantity) {
        Order order = orderService.getById(orderId);
        OrderDetails orderDetails = orderService.findOrderDetailsByProductIdAndOrderId(productId, orderId).get();
        orderDetails.setQuantity(quantity);
        orderDetails.setTotal(quantity * orderDetails.getProductId().getListPrice());

        List<OrderDetails> listOrderDetails = orderService.findByOrderId(orderId);
        double sum = 0;
        for (OrderDetails o : listOrderDetails) {
            sum += o.getTotal();
        }
        order.setTotalPrice(sum);
        orderService.saveItem(orderDetails);
        orderService.saveOrder(order);
        return "Cập nhật số lượng thành công";
    }
}
