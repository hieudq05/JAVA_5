package org.labpoly.lab2.controller;

import org.labpoly.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("product")
public class ProductController {
    @GetMapping("form")
    public String form() {
        return "product";
    }

    @PostMapping("save")
    public String save(@RequestParam("name") String name, @RequestParam("price") Double price, Model model) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .build();
        model.addAttribute("product", product);
        return "product";
    }
}
