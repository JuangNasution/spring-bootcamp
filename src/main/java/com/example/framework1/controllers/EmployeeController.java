package com.example.framework1.controllers;

import com.example.framework1.models.Employee;
import com.example.framework1.services.DepartmentService;
import com.example.framework1.services.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeRepository, DepartmentService departmentRepository) {
        this.employeeService = employeeRepository;
        this.departmentService = departmentRepository;
    }

    @GetMapping("")
    public String main(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @PostMapping("/save")
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("departments", departmentService.findAll());
        return "employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        employeeService.delete(id);
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        return "redirect:/employee";
    }
}
