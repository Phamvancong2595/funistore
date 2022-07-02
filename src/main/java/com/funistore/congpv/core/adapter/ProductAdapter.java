package com.funistore.congpv.core.adapter;

import com.funistore.congpv.core.domain.Product;

import java.util.List;

public interface ProductAdapter {
    List<Product> loadAllProducts();
    void insertNewProduct(Product product);
    Product loadProductDetails(Long id);
}
