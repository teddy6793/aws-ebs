package com.tien.web_shop_online.beans;

import com.tien.web_shop_online.entities.Product;

public class ValidateProduct {
  public static boolean checkQuantity(Integer quantityInput, Product product) {
    if (quantityInput > product.getQuantity()) {
      return false;
    }
    return true;
  }
}
