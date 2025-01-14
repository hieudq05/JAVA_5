package org.labpoly.lab4.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import org.labpoly.lab4.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("staff")
@MultipartConfig
public class StaffController {

    private Staff staff;

    public StaffController(Staff staff) {
        this.staff = staff;
    }

    @GetMapping("form")
    public String form(Model model) {
        model.addAttribute("staff", staff);
        if (staff.getEmail() == null) {
            model.addAttribute("message", "Please enter your information!");
        }
        return "form";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("staff") Staff staffParam, Errors errors, Model model, @RequestPart("photo_file") MultipartFile file) {
        if(errors.hasErrors() && file.isEmpty()) {
            System.out.println(errors.getErrorCount()+" ERRORS");
            System.out.println(file.isEmpty());
            model.addAttribute("staff", staffParam);
            model.addAttribute("message", "Please enter your information!");
            return "form";
        }

            System.out.println("SAVED");
            staffParam.setPhoto(file.getOriginalFilename());
            staff = staffParam;

        return "redirect:/staff/form";
    }

}
