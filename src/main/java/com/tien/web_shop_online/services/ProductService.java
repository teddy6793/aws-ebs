package com.tien.web_shop_online.services;

import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.ProductBrand;
import com.tien.web_shop_online.entities.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductService{

    List<Product> findAllProduct();

    List<ProductCategory> findAllCategory();

    List<Product> findProductByName(String name);

    List<ProductBrand> findAllBrand();

    List<Product> findTop6ProductByCategoryId(Integer id);

    List<Product> searchByName(String name);

    List<Product> findAllByCategoryId(Integer id);

    Optional<ProductCategory> findCategoryById(Integer id);

    Optional<ProductBrand> findBrandById(Integer id);

    Product findProductById(Integer id);

    void deleteProductById(Integer id);

    void saveProduct(Product product);

    void deleteBrandById(Integer id);

    void saveBrand(ProductBrand brand);

    void deleteCategoryById(Integer id);

    void saveCategory(ProductCategory category);
}
