package org.labpoly.lab6.controller;

import org.labpoly.lab6.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportByCategoryController {

    private final CategoryService categoryService;

    public ReportByCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("report/category")
    public String reportByCategory(Model model) {
        model.addAttribute("reports", categoryService.reportByCategory());
        return "reportByCategory";
    }
}
