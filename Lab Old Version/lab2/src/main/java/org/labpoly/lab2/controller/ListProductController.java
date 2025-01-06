package org.labpoly.lab2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.labpoly.lab2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("products")
public class ListProductController {
    List<Product> products = new ArrayList<>();

    @Autowired
    HttpServletRequest request;

    @GetMapping("form")
    public String form() {
        if (products.size() == 0) {
            products.add(new Product("Macbook", 9999.6));
        }
        request.setAttribute("products", products);
        return "productsForm";
    }

    @PostMapping("save")
    public String save(@RequestParam Map<String, String[]> requestParams) throws InvocationTargetException, IllegalAccessException {
        Product product = new Product();
        BeanUtils.populate(product, requestParams);
        products.add(product);
        request.setAttribute("products", products);
        return "productsForm";
    }
}
