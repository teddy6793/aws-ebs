package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.ProductBrand;
import com.tien.web_shop_online.entities.ProductCategory;
import com.tien.web_shop_online.repositories.ProductBrandRepository;
import com.tien.web_shop_online.repositories.ProductCategoryRepository;
import com.tien.web_shop_online.repositories.ProductRepository;
import com.tien.web_shop_online.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductImplement implements ProductService {

    @Autowired
    private ProductRepository rpProduct;

    @Autowired
    private ProductBrandRepository rpBrand;

    @Autowired
    private ProductCategoryRepository rpCategory;

    // Product
    @Override
    public Product findProductById(Integer id) {
        return rpProduct.getById(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return rpProduct.findAll();
    }

    @Override
    public void deleteProductById(Integer id) {
        rpProduct.deleteById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return rpProduct.findByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        rpProduct.save(product);
    }

    @Override
    public List<Product> findTop6ProductByCategoryId(Integer id) {
        ProductCategory category = rpCategory.getById(id);
        return rpProduct.findTop6ByCategoryId(category);
    }

    @Override
    public List<Product> searchByName(String name) {
        return rpProduct.searchProductByName(name);
    }

    @Override
    public List<Product> findAllByCategoryId(Integer id) {
        ProductCategory category = rpCategory.getById(id);

        return rpProduct.findAllByCategoryId(category);
    }

    // Brand
    @Override
    public Optional<ProductBrand> findBrandById(Integer id) {
        return rpBrand.findById(id);
    }

    @Override
    public List<ProductBrand> findAllBrand() {
        return rpBrand.findAll();
    }

    @Override
    public void deleteBrandById(Integer id) {
        rpBrand.deleteById(id);
    }

    @Override
    public void saveBrand(ProductBrand brand) {
        rpBrand.save(brand);
    }

    // Category
    @Override
    public Optional<ProductCategory> findCategoryById(Integer id) {
        return rpCategory.findById(id);
    }

    @Override
    public List<ProductCategory> findAllCategory() {
        return rpCategory.findAll();
    }

    @Override
    public void deleteCategoryById(Integer id) {
        rpCategory.deleteById(id);
    }

    @Override
    public void saveCategory(ProductCategory category) {
        rpCategory.save(category);
    }
}
