package org.labpoly.lab3.controller;

import org.labpoly.lab3.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListStaffsController {
    @GetMapping("staffs/details")
    public String listStaffs(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build());
        model.addAttribute("staffs", list);
        return "staffs";
    }

    @GetMapping("staffs/table")
    public String listStaffsTable(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build());
        model.addAttribute("staffs", list);
        return "staffTable";
    }

    @GetMapping("staffs/form")
    public String listStaffsForm(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build());
        model.addAttribute("staffs", list);
        return "staffForm";
    }
}
