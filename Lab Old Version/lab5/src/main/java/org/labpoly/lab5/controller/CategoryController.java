package org.labpoly.lab5.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.labpoly.lab5.model.Category;
import org.labpoly.lab5.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public CategoryController(CategoryService categoryService, HttpServletRequest request, HttpServletResponse response) {
        this.categoryService = categoryService;
        this.request = request;
        this.response = response;
    }

    @GetMapping
    public String showCategory(Model model, @RequestParam(required = false, name = "id") String id) {
        if(request.getParameter("message") != null) {
            model.addAttribute("message", request.getParameter("message"));
        }
        if(id != null) {
            model.addAttribute("category", categoryService.findById(id));
        }
        model.addAttribute("categories", categoryService.findAll());
        return "category";
    }

    @PostMapping("add")
    public String addCategory(@RequestParam String name, @RequestParam String id, RedirectAttributes redirectAttributes) {
        Category category = Category.builder().id(id).name(name).build();
        if(categoryService.findById(category.getId()) != null) {
            redirectAttributes.addAttribute("message", "Category id is duplicated!");
        } else {
            categoryService.save(category);
        }
        return "redirect:/category";
    }

    @PostMapping("update")
    public String updateCategory(@RequestParam String name, @RequestParam String id, RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(id);
        if(category==null) {
            redirectAttributes.addAttribute("message", "Category is duplicated!");
        } else {
            category.setName(name);
            categoryService.save(category);
        }
        return "redirect:/category";
    }

    @PostMapping("delete")
    public String deleteCategory(@RequestParam String id) {
        categoryService.deleteById(id);
        return "redirect:/category";
    }
}
