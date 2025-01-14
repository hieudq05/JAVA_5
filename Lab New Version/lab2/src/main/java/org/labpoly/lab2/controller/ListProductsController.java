package org.labpoly.lab2.controller;

import org.labpoly.lab2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("products")
public class ListProductsController {

    private final List<Product> products;

    public ListProductsController(List<Product> products) {
        this.products = products;
    }

    @ModelAttribute("products")
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("form")
    public String form(Model model) {
        Product product = Product.builder()
                .name("Product "+Math.random())
                .price(Math.random())
                .build();
        model.addAttribute("product", product);
        return "listProducts";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Product product) {
        products.add(product);
        return "redirect:/products/form";
    }
}
