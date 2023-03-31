package com.jac.thymleaf.SpringMVCProject.service;

import com.jac.thymleaf.SpringMVCProject.entity.EmployeeEntity;
import com.jac.thymleaf.SpringMVCProject.mapper.MapperHelper;
import com.jac.thymleaf.SpringMVCProject.model.Employee;
import com.jac.thymleaf.SpringMVCProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final MapperHelper mapperHelper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, MapperHelper mapperHelper) {
        this.employeeRepository = employeeRepository;
        this.mapperHelper = mapperHelper;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return mapperHelper.convertEmployeeEntityListToEmployeeList(employeeEntities);
    }
}
