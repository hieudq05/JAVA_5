package org.labpoly.lab3.controller;

import org.labpoly.lab3.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {

    @GetMapping("staff/details")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .level(2)
                .build();
        model.addAttribute("staff"
                , staff);
        return "staff-details";
    }
}
