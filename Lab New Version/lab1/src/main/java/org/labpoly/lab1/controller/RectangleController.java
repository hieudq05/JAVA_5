package org.labpoly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("rectangle")
public class RectangleController {
    @GetMapping
    public String showForm() {
        return "rectangle";
    }

    @PostMapping
    public String process(@RequestParam("width") double w, @RequestParam("height") double h, Model model) {
        model.addAttribute("s", w * h);
        model.addAttribute("p", (w + h) * 2);
        return "rectangle";
    }
}
