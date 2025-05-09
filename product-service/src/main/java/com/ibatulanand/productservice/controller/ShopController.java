package com.ibatulanand.productservice.controller;

import com.ibatulanand.productservice.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    private final ProductService productService;

    public ShopController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";          // looks for templates/products.html
    }
}

