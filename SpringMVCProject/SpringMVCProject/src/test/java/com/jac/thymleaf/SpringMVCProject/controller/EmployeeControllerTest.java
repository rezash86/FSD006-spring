package com.jac.thymleaf.SpringMVCProject.controller;


//https://docs.pact.io/ -> contract test

import com.jac.thymleaf.SpringMVCProject.model.Employee;
import com.jac.thymleaf.SpringMVCProject.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void whenCallGetAllEmployees_return200_withData() throws Exception {
        List<Employee> employees = List.of(Employee.builder().id(1L).firstName("reza").build());
        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employee/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("employees/list-employees"))
                .andExpect(model().attribute("employees", employees))
                .andDo(print());
    }

}
