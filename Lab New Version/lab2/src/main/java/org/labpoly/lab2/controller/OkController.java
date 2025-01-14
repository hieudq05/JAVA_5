package org.labpoly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ctrl/ok")
public class OkController {
    @GetMapping
    public String m2(Model model) {
            model.addAttribute("message", "GET Method");
        return "ok";
    }

    @PostMapping
    public String m1(Model model, @RequestParam(value = "x", required = false) String x) {
        if (x != null) {
            model.addAttribute("message", "POST Method + Parram value: "+x);
        } else {
            model.addAttribute("message", "POST Method");
        }
        return "ok";
    }
}
