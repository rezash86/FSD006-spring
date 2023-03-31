package com.jac.thymleaf.SpringMVCProject.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.thymleaf.SpringMVCProject.entity.EmployeeEntity;
import com.jac.thymleaf.SpringMVCProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperHelper {

    private final ObjectMapper mapper;

    @Autowired
    public MapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Employee> convertEmployeeEntityListToEmployeeList(List<EmployeeEntity> entities){
        List<Employee> employees = new ArrayList<>();
        for(EmployeeEntity entity: entities){
            employees.add(mapper.convertValue(entity, Employee.class));
        }
        return employees;
    }
}
