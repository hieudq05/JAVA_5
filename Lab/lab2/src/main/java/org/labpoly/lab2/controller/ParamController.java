package org.labpoly.lab2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("param")
public class ParamController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("form")
    public String form() {
        request.setAttribute("y", "?");
        request.setAttribute("x", "?");
        return "form";
    }

    @PostMapping("save/{id}")
    public String save(@RequestParam String y, @PathVariable String id) {
        System.out.println(y);
        request.setAttribute("y", y);
        request.setAttribute("x", id);
        return "form";
    }
}
