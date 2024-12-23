package org.labpoly.lab2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ctrl")
public class ctrlController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("ok")
    public String okGet() {
        request.setAttribute("method", "GET");
        return "ok";
    }

    @PostMapping(value = "ok", params = "x")
    public String okPostParam() {
        request.setAttribute("method", "POST Param");
        return "ok";
    }

    @PostMapping("ok")
    public String okPost() {
        request.setAttribute("method", "POST");
        return "ok";
    }

}
