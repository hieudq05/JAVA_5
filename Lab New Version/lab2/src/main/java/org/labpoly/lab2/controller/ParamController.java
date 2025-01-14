package org.labpoly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("param/save")
public class ParamController {
    @GetMapping("{x}")
    public String param(@PathVariable("x") String x, Model model) {
        model.addAttribute("x", x);
        return "param";
    }

    @PostMapping("{x}")
    public String paramPost(@PathVariable("x") String x, @RequestParam("y") String y, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "param";
    }
}
