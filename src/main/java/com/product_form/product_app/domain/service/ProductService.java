package com.product_form.product_app.domain.service;

import java.util.List;

import com.product_form.product_app.domain.entity.Product;

public interface ProductService {
    public void saveProduct(Product product);
    public List<Product> listProducts();
}
