package com.jac.thymleaf.SpringMVCProject.controller;

import com.jac.thymleaf.SpringMVCProject.exception.EmployeeNotFoundException;
import com.jac.thymleaf.SpringMVCProject.model.Employee;
import com.jac.thymleaf.SpringMVCProject.service.EmployeeService;
import com.jac.thymleaf.SpringMVCProject.view.EmployeeView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

        //if you want to have something different in the view , forexample Employee
        //with additional fields like Gender, accountNo that are existing in the model/empl plackage
        //then you have to convert it to the EmployeeVIEW which is customized class for your purposeses

        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute to bind form data
        Employee theEmployee= new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("empId") Long theId, Model theModel){
       // get the employee from the service
        try {
            Employee existingEmp = employeeService.getEmployeeById(theId);
            theModel.addAttribute("employee", existingEmp);

            return "employees/employee-form";
        }catch (EmployeeNotFoundException exception){
            theModel.addAttribute("employee", null);
            theModel.addAttribute("exceptionMessage", exception.getMessage());
            return "employees/employee-form";
        }
    }


    @PostMapping("/upsert")
    public String upsertEmployee(@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult result){
        //https://www.baeldung.com/spring-thymeleaf-error-messages
        if (result.hasErrors()) {
            return "employees/employee-form";
        }

        employeeService.save(theEmployee);

        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("empId") Long theId){
        //delete the employee
        employeeService.deleteEmployee(theId);

        return "redirect:/employee/list";
    }
}
