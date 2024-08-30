package com.product_form.product_app.application;

import com.product_form.product_app.domain.entity.Product;
import com.product_form.product_app.domain.service.ProductService;

public class SaveProductUseCase {
    private final ProductService productService;

    public SaveProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public void execute(Product product) {
        productService.saveProduct(product);
    }
}
