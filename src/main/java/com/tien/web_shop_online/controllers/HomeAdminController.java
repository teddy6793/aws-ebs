package com.tien.web_shop_online.controllers;

import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/web_shop/admin")
public class HomeAdminController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    StatsService statsService;

    Integer page = 0;

    @RequestMapping(value = {"/","/home","trangchu","management",""})
    public String homeAdminPage(Model model){
        List<Product> listProduct = productService.findTop6ProductByCategoryId(1);
        List<Customer> customerList = customerService.findTop5Customer();
        double profitValue = statsService.getProfitUpToNow();

        model.addAttribute("profitValue", String.format("%,.0f", profitValue));
        model.addAttribute("listProduct",listProduct);
        model.addAttribute("listUser",customerList);
        model.addAttribute("page",page);

        return "admin_page/admin_home_page";
    }

}
