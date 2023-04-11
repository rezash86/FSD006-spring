package com.jac.thymleaf.SpringMVCProject.service;

import com.jac.thymleaf.SpringMVCProject.entity.EmployeeEntity;
import com.jac.thymleaf.SpringMVCProject.mapper.MapperHelper;
import com.jac.thymleaf.SpringMVCProject.model.Employee;
import com.jac.thymleaf.SpringMVCProject.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl target;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private MapperHelper mapperHelper;

    @Test
    void test_getAllEmployees_returnsAList(){
        //initialize - assumption
        List<EmployeeEntity> expectedEmployeeEntities = new ArrayList<>();
        expectedEmployeeEntities.add(EmployeeEntity.builder()
                        .id(1L)
                        .firstName("test1_first_name")
                        .lastName("test1_last_name")
                        .email("test1@g.com")
                .build());
        expectedEmployeeEntities.add(EmployeeEntity.builder()
                .id(2L)
                .firstName("test2_first_name")
                .lastName("test2_last_name")
                .email("test2@g.com")
                .build());
        expectedEmployeeEntities.add(EmployeeEntity.builder()
                .id(3L)
                .firstName("test3_first_name")
                .lastName("test3_last_name")
                .email("test3@g.com")
                .build());

        List<Employee> expectedEmployees = new ArrayList<>();
        Employee employee1 = Employee.builder()
                .id(1L)
                .firstName("test1_first_name")
                .lastName("test1_last_name")
                .email("test1@g.com")
                .build();
        expectedEmployees.add(employee1);
        expectedEmployees.add(Employee.builder()
                .id(2L)
                .firstName("test2_first_name")
                .lastName("test2_last_name")
                .email("test2@g.com")
                .build());
        expectedEmployees.add(Employee.builder()
                .id(3L)
                .firstName("test3_first_name")
                .lastName("test3_last_name")
                .email("test3@g.com")
                .build());

        when(employeeRepository.findAll()).thenReturn(expectedEmployeeEntities);
        when(mapperHelper.convertEmployeeEntityListToEmployeeList(expectedEmployeeEntities)).thenReturn(expectedEmployees);

        //real call
        List<Employee> actual =  target.getAllEmployees();

        //assertion
        assertNotNull(actual);
        assertEquals(3, actual.size());
        assertEquals(employee1, actual.get(0));
        assertEquals(employee1.getEmail(), actual.get(0).getEmail());
    }

    @Test
    void test_empty_result(){
        when(employeeRepository.findAll()).thenReturn(Collections.emptyList());
        when(mapperHelper.convertEmployeeEntityListToEmployeeList(Collections.emptyList())).thenReturn(Collections.emptyList());

        List<Employee> actual =  target.getAllEmployees();

        assertNotNull(actual);
        assertEquals(0, actual.size());
    }
}
