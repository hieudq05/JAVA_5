package org.labpoly.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public String showLogin(Model model) {
        return "login";
    }

    @PostMapping
    public String login(Model model, @RequestParam String username, @RequestParam String password) {
        if(username.equals("admin") && password.equals("123")) {
            model.addAttribute("status", "Login Successful");
        } else {
            model.addAttribute("status", "Login Failed");
        }
        return "login";
    }
}
