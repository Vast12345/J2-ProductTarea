package com.product_form.product_app.application;

import java.util.List;

import com.product_form.product_app.domain.entity.Product;
import com.product_form.product_app.domain.service.ProductService;

public class ListProductUseCase {
    private final ProductService productService;

    public ListProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> execute() {
        return productService.listProducts();
    }
}
