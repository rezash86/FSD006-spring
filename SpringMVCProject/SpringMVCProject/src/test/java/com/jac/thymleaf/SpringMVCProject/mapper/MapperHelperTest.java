package com.jac.thymleaf.SpringMVCProject.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.thymleaf.SpringMVCProject.entity.EmployeeEntity;
import com.jac.thymleaf.SpringMVCProject.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MapperHelperTest {

    @InjectMocks
    private MapperHelper target;

    @Mock
    private ObjectMapper mapper;

    @Test
    void test_convertEmployeeEntityListToEmployeeList_givesData(){
        //assumption - initialize
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

        Employee expectedEmployee1 = Employee.builder()
                .id(1L)
                .firstName("test1_first_name")
                .lastName("test1_last_name")
                .email("test1@g.com")
                .build();
        Employee expectedEmployee2 = Employee.builder()
                .id(2L)
                .firstName("test2_first_name")
                .lastName("test2_last_name")
                .email("test2@g.com")
                .build();

        Employee expectedEmployee3 = Employee.builder()
                .id(3L)
                .firstName("test3_first_name")
                .lastName("test3_last_name")
                .email("test3@g.com")
                .build();

        when(mapper.convertValue(expectedEmployeeEntities.get(0), Employee.class)).thenReturn(expectedEmployee1);
        when(mapper.convertValue(expectedEmployeeEntities.get(1), Employee.class)).thenReturn(expectedEmployee2);
        when(mapper.convertValue(expectedEmployeeEntities.get(2), Employee.class)).thenReturn(expectedEmployee3);


        //real call
        List<Employee> actual = target.convertEmployeeEntityListToEmployeeList(expectedEmployeeEntities);

        //assertion
        assertEquals(3, actual.size());
        assertEquals(expectedEmployee1, actual.get(0));
        assertEquals(expectedEmployee2, actual.get(1));
        assertEquals(expectedEmployee3, actual.get(2));

    }
}
