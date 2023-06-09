package com.jac.thymleaf.SpringMVCProject.service;

import com.jac.thymleaf.SpringMVCProject.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Long save(Employee employee);

    Employee getEmployeeById(Long empId);

    void deleteEmployee(Long empId);
}
