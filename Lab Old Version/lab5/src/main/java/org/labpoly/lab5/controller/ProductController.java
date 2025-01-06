package org.labpoly.lab5.controller;

import org.labpoly.lab5.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("sort/{sortBy}")
    public String sort(@PathVariable String sortBy, Model model) {
        model.addAttribute("sortBy", "SORT BY "+sortBy);
        model.addAttribute("products", productService.productsSortByPropAsc(sortBy));
        return "product";
    }

    // PAGING PRODUCT
    @GetMapping("page")
    public String productPage(@RequestParam("index") int index, Model model) {
        model.addAttribute("products", productService.getProductsOnPage(index, 5));
        return "productPagination";
    }
}
