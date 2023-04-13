package com.jac.thymleaf.SpringMVCProject.service;

import com.jac.thymleaf.SpringMVCProject.entity.EmployeeEntity;
import com.jac.thymleaf.SpringMVCProject.exception.EmployeeNotFoundException;
import com.jac.thymleaf.SpringMVCProject.mapper.MapperHelper;
import com.jac.thymleaf.SpringMVCProject.model.Employee;
import com.jac.thymleaf.SpringMVCProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Long save(Employee employee) {
        EmployeeEntity entity = mapperHelper.convertEmployeeToEmployeeEntity(employee);
        var result = employeeRepository.save(entity);
        return result.getId();
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        Optional<EmployeeEntity> foundEmp = employeeRepository.findById(empId);
        if(foundEmp.isEmpty()){
            throw new EmployeeNotFoundException("the employee could not be found -> " +  empId);
        }
        else{
            return mapperHelper.convertEmployeeEntityToEmployee(foundEmp.get());
        }
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
