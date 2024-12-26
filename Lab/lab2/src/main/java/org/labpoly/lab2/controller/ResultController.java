package org.labpoly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("result")
public class ResultController {
    @GetMapping("a")
    public String a() {
        return "a";
    }

    @GetMapping("b")
    public String b(Model model) {
        model.addAttribute("message", "I'm from b");
        return "forward:/result/a";
    }

    @GetMapping("c")
    public String c(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message", "I'm from c");
        return "redirect:/result/a";
    }

    @GetMapping("d")
    @ResponseBody
    public String d() {
        return "I'm from d";
    }
}
