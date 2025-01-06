package org.labpoly.lab6.controller;

import org.labpoly.lab6.model.Product;
import org.labpoly.lab6.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product/filtername")
public class FilterNameController {

    private final ProductService productService;

    public FilterNameController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProducts(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("products", productService.findProductsByNameLikeOnPage((name==null?"":name), (page==null?0:page), 5));
        model.addAttribute("name", name==null?"":name);
        return "filterProductByName";
    }
}
