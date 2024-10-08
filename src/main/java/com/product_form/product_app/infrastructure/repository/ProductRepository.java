package com.product_form.product_app.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import com.product_form.product_app.domain.entity.Product;
import com.product_form.product_app.domain.service.ProductService;

public class ProductRepository implements ProductService{
    private List<Product> productList;

    public ProductRepository() {
        this.productList = new ArrayList<>();
    }

    @Override
    public void saveProduct(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> listProducts() {
        return productList;
    }
}
