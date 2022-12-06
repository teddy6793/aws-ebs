package com.tien.web_shop_online.controllers;

import com.tien.web_shop_online.entities.Customer;
import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.ProductBrand;
import com.tien.web_shop_online.entities.ProductCategory;
import com.tien.web_shop_online.repositories.ProductBrandRepository;
import com.tien.web_shop_online.repositories.ProductCategoryRepository;
import com.tien.web_shop_online.repositories.ProductRepository;
import com.tien.web_shop_online.services.CustomerService;
import com.tien.web_shop_online.services.ProductService;
import com.tien.web_shop_online.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class ViewController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository categoryRepository;

    @Autowired
    ProductBrandRepository brandRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Autowired
    StatsService statsService;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    Integer page;

    // Sign in & Sign up form

    @RequestMapping(value = "/sign_in_sign_up")
    public String signInSignUpPag(Model model) {
        Customer c = new Customer();
        model.addAttribute("customer", c);

        return "client_page/sign_in_sign_up_form";
    }

    @RequestMapping(value = "/check_mail")
    public String checkMailPage() {
        return "client_page/check_mail";
    }

    @RequestMapping(value = "/input_forgot_password")
    public String forgotPasswordPage() {
        return "client_page/input_email_forgot_password";
    }

    // Home page
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productPageClient(Model model) {
        List<Product> productList = productRepository.findAll();
        Collections.reverse(productList);
        List<ProductCategory> productCategoryList = productService.findAllCategory();
        Collections.reverse(productCategoryList);
        model.addAttribute("listProduct", productList);
        model.addAttribute("productCategoryList", productCategoryList);

        return "client_page/products";
    }



    @RequestMapping(value = {"/index","","/","/home","trangchu"}, method = RequestMethod.GET)
    public String homePage(Model model) {

        Optional<ProductCategory> manCategory = productCategoryRepository.findByName("Dành cho nam");
        Optional<ProductCategory> womenCategory = productCategoryRepository.findByName("Dành cho nữ");
        Optional<ProductCategory> kidCategory = productCategoryRepository.findByName("Dành cho trẻ");

        List<Product> listProductMan = productService.findTop6ProductByCategoryId(manCategory.get().getId());
        List<Product> listProductWomen = productService.findTop6ProductByCategoryId(womenCategory.get().getId());
        List<Product> listProductKid = productService.findTop6ProductByCategoryId(kidCategory.get().getId());

        model.addAttribute("listProductMan", listProductMan);
        model.addAttribute("listProductWomen", listProductWomen);
        model.addAttribute("listProductKid", listProductKid);
        model.addAttribute("man", manCategory.get());
        model.addAttribute("women", womenCategory.get());
        model.addAttribute("kid", kidCategory.get());


        return "client_page/index";
    }

    @RequestMapping(value = "/contact")
    public String contactPage(Model model) {

        return "client_page/contact";
    }

    @RequestMapping(value = "/about")
    public String aboutPage(Model model) {

        return "client_page/about";
    }

    @RequestMapping(value = "/cart")
    public String cartPage(Model model) {

        return "client_page/cart";
    }


    // Product pages

    @RequestMapping(value = "/web_shop/admin/products")
    public String productPage(Model model) {
        List<Product> productList = productRepository.findAll();
        int amount = productList.size();
        page = 1;
        double profitValue = statsService.getProfitUpToNow();

        model.addAttribute("profitValue", String.format("%,.0f", profitValue));
        model.addAttribute("listProducts", productList);
        model.addAttribute("amount", amount);
        model.addAttribute("page", page);
        return "admin_page/admin_product_product";
    }


    @RequestMapping(value = "/web_shop/admin/products/new")
    public String addProductPage(Model model) {
        Product product = new Product();
        List<ProductCategory> listCategory = categoryRepository.findAll();
        List<ProductBrand> listBrand = brandRepository.findAll();
        page = 1;
        double profitValue = statsService.getProfitUpToNow();

        model.addAttribute("profitValue", String.format("%,.0f", profitValue));
        model.addAttribute("product", product);
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("page", page);
        return "admin_page/admin_product_product_add_product";
    }

    @RequestMapping(value = "/web_shop/admin/products/brands")
    public String brandPage(Model model) {
        List<ProductBrand> listBrand = brandRepository.findAll();
        Integer amount = listBrand.size();
        page = 1;
        double profitValue = statsService.getProfitUpToNow();

        model.addAttribute("profitValue", String.format("%,.0f", profitValue));
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("amount", amount);
        model.addAttribute("page", page);
        return "admin_page/admin_product_brand";
    }

    @RequestMapping(value = "/web_shop/admin/products/brands/new")
    public String newBrand(Model model) {
        ProductBrand b = new ProductBrand();
        page = 1;
        double profitValue = statsService.getProfitUpToNow();

        model.addAttribute("profitValue", String.format("%,.0f", profitValue));
        model.addAttribute("title", "Thêm thương hiệu");
        model.addAttribute("_action", "Thêm");
        model.addAttribute("brand", b);

        model.addAttribute("page", page);
        return "admin_page/admin_product_brand_form";
    }

    @RequestMapping(value = "/web_shop/admin/products/categories/new")
    public String newCategory(Model model) {
        ProductCategory c = new ProductCategory();
        page = 1;
        double profitValue = statsService.getProfitUpToNow();

        model.addAttribute("profitValue", String.format("%,.0f", profitValue));
        model.addAttribute("category", c);
        model.addAttribute("title", "Thêm loại sản phẩm");
        model.addAttribute("_action", "Thêm");
        model.addAttribute("page", page);
        return "admin_page/admin_product_category_form";
    }

    // Customer

    @RequestMapping(value = "/web_shop/admin/customers")
    public String adminCustomerPage(Model model) {
        List<Customer> listCustomer = customerService.findAllCustomer();
        page = 4;
        double profitValue = statsService.getProfitUpToNow();

        model.addAttribute("profitValue", String.format("%,.0f", profitValue));
        model.addAttribute("listCustomer", listCustomer);
        model.addAttribute("page", page);

        return "admin_page/admin_customer";
    }

    @RequestMapping(value = "/checked")
    public String checkedPage() {
        return "client_page/checked";
    }
}
