package com.ibatulanand.productservice.controller;

import com.ibatulanand.productservice.dto.ProductRequest;
import com.ibatulanand.productservice.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shop")
public class ProductPageController {

    private final ProductService productService;

    public ProductPageController(ProductService productService) {
        this.productService = productService;
    }

    // GET  /shop           → list page
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("newProduct", new ProductRequest());
        return "products";          // resolves to templates/products.html
    }

    // POST /shop           → add a new product, then redirect
    @PostMapping
    public String create(@ModelAttribute("newProduct") ProductRequest req) {
        productService.createProduct(req);
        return "redirect:/shop";
    }
}
