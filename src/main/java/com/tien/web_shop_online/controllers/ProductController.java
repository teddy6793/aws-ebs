package com.tien.web_shop_online.controllers;


import com.tien.web_shop_online.entities.Feedback;
import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.ProductCategory;
import com.tien.web_shop_online.services.FeedbackService;
import com.tien.web_shop_online.services.ProductService;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value="/products/category/{id}")
    public String showProductByCategory(@PathVariable Integer id,
                                        Model model){
        List<ProductCategory> productCategoryList = productService.findAllCategory();
        Collections.reverse(productCategoryList);
        List<Product> productList = productService.findAllByCategoryId(id);
        Collections.reverse(productList);

        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("listProduct",productList);

        return "client_page/products";
    }

    @RequestMapping(value = "/product/single_product/{id}")
    public String singlePageProduct(@PathVariable Integer id, Model model){
        Product product = productService.findProductById(id);
        List<Product> top6ProductRelate = productService.findTop6ProductByCategoryId(
                product.getCategoryId().getId());
        List<Feedback> listFeedbacks = feedbackService.findFeedbackByProductId(id);
        Collections.reverse(top6ProductRelate);


        model.addAttribute("listFeedback", listFeedbacks);
        model.addAttribute("productRelate", top6ProductRelate);
        model.addAttribute("product",product);

        return "client_page/single_product";
    }

    @RequestMapping(value="/search_product")
    public String searchProduct(@RequestParam("keyWord") String keyWord,
                                Model model){
        List<Product> searchProduct = productService.searchByName(keyWord);
        List<ProductCategory> productCategoryList = productService.findAllCategory();
        Collections.reverse(searchProduct);
        Collections.reverse(productCategoryList);

        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("listProduct",searchProduct);

        return "client_page/products";
    }

}
