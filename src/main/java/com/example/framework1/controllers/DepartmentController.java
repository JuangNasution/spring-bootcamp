package com.example.framework1.controllers;

import com.example.framework1.models.Department;
import com.example.framework1.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Juang Nasution
 */
@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("department", new Department());
        return "index";
    }

    @PostMapping("/save")
    public String save(Department department) {
        departmentService.save(department);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("department", departmentService.findById(id));

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        departmentService.delete(id);
        model.addAttribute("employees", departmentService.findAll());
        return "redirect:/";
    }
}
