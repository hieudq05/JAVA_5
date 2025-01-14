package org.labpoly.lab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutFragController {

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("fragName", "home");
        return "layoutFrag";
    }

    @GetMapping("about")
    public String about(Model model) {
        model.addAttribute("fragName", "about");
        return "layoutFrag";
    }
}
