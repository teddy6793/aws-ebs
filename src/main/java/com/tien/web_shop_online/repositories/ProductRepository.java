package com.tien.web_shop_online.repositories;

import com.tien.web_shop_online.entities.Product;
import com.tien.web_shop_online.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> findByName(String name);

  List<Product> findFirstByCategoryId(ProductCategory id);

  List<Product> findTop6ByCategoryId(ProductCategory id);

  List<Product> findAllByCategoryId(ProductCategory id);

  @Query(value = "SELECT * FROM tbl_product p WHERE p.name LIKE %:key%", nativeQuery = true)
  List<Product> searchProductByName(@Param("key") String key);
}
