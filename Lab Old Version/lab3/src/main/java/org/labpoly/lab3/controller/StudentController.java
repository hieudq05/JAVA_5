package org.labpoly.lab3.controller;

import jakarta.validation.Valid;
import org.labpoly.lab3.model.Faculty;
import org.labpoly.lab3.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student")
public class StudentController {
    @ModelAttribute("student")
    public Student getStudent() {
        return new Student();
    }

    @ModelAttribute("faculty")
    public List<Faculty> faculty() {
        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(new Faculty("IT", "Information Technology"));
        facultyList.add(new Faculty("PR", "Public Relation"));
        facultyList.add(new Faculty("MKT", "Marketing"));
        return facultyList;
    }

    @ModelAttribute("gender")
    public Map<Boolean, String> gender() {
        Map<Boolean, String> gender = new HashMap<>();
        gender.put(true, "Male");
        gender.put(false, "Female");
        return gender;
    }

    @ModelAttribute("hobbies")
    public Map<String, String> hobbies() {
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("Dog", "Dog");
        hobbies.put("Cat", "Cat");
        hobbies.put("Mouse", "Mouse");
        hobbies.put("Rogue", "Rogue");
        return hobbies;
    }

    @GetMapping("form")
    public String form(@ModelAttribute("student") Student student) {
        return "studentForm";
    }

    @PostMapping("form")
    public String submit(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, Model model) {
        if(!bindingResult.hasErrors()) {
            model.addAttribute("message", "You have successfully added a new student.");
        }
        return "studentForm";
    }
}
