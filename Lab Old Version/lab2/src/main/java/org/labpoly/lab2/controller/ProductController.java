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
import java.util.Map;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("form")
    public String form() {
        return "productForm";
    }

    @PostMapping("save")
    public String save(@RequestParam Map<String, String[]> product) throws InvocationTargetException, IllegalAccessException {
        Product product1 = new Product();
        BeanUtils.populate(product1, product);
        request.setAttribute("product", product1);
        return "productForm";
    }
}
