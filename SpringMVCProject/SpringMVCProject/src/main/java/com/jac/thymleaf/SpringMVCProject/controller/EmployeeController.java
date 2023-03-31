package com.jac.thymleaf.SpringMVCProject.controller;

import com.jac.thymleaf.SpringMVCProject.model.Employee;
import com.jac.thymleaf.SpringMVCProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees =  employeeService.getAllEmployees();

        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

}
