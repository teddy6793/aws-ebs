package com.tien.web_shop_online.repositories;

import com.tien.web_shop_online.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    Optional<ProductCategory> findByName(String name);

}
