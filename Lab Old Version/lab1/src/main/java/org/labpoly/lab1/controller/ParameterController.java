package org.labpoly.lab1.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParameterController {
    @Autowired
    ServletContext application;

    @GetMapping("/param")
    public String getParam(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return "param";
    }

    @PostMapping("/param")
    public String postParam(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cookieParam = request.getParameter("cookie");
        response.addCookie(new Cookie(username, cookieParam));

        System.out.println("COOKIE which name is \"user\"------");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().contains("user")) {
                System.out.println(cookie + " - " + cookie.getName() + " - " + cookie.getValue());
            }
        }
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);
        return "param";
    }
}
