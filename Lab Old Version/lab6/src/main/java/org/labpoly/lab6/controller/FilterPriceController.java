package org.labpoly.lab6.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.labpoly.lab6.model.Product;
import org.labpoly.lab6.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("product/price")
public class FilterPriceController {

    private final ProductService productService;

    public FilterPriceController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "filterProductByPrice";
    }

    @PostMapping
    public String filterProduct(@RequestParam("price_min") Double priceMin, @RequestParam("price_max") Double priceMax, Model model) {
        model.addAttribute("products", productService.findProductByPriceBetween(priceMin, priceMax));
        return "filterProductByPrice";
    }
}
