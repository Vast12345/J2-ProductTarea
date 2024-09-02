package com.product_form.product_app.infrastructure.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.product_form.product_app.application.ListProductUseCase;
import com.product_form.product_app.application.SaveProductUseCase;
import com.product_form.product_app.domain.entity.Product;
import com.product_form.product_app.domain.service.ProductService;
import com.product_form.product_app.infrastructure.repository.ProductRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
    private ProductService productService;
    private SaveProductUseCase saveProductUseCase;
    private ListProductUseCase listProductUseCase;
    
    public ProductController() {
        this.productService = new ProductRepository();
        this.saveProductUseCase = new SaveProductUseCase(productService);
        this.listProductUseCase = new ListProductUseCase(productService);
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }


    @PostMapping("/submitProduct")
    public String productForm(HttpServletRequest request) {
        int code = Integer.parseInt(request.getParameter("code"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        
        Product product = new Product(code, name, price, stock);

        saveProductUseCase.execute(product);
        System.out.println(product);

        return "form";
    }

    @GetMapping("/products")
    public String listProducts(ModelMap model) {
        List<Product> productList = new ArrayList<>();
        productList = listProductUseCase.execute();
        System.out.println(productList + "    HEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        model.addAttribute("products", productList);

        return "productview";
    }
}
