package com.example.demo;

import com.example.demo.one_to_n.controller.CompanyController;
import com.example.demo.one_to_n.controller.EmployeeController;
import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.entity.Employee;
import com.example.demo.one_to_n.service.CompanyService;
import com.example.demo.one_to_n.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void should_return_employee_when_deleteEmployee() throws Exception {
        Employee employee = new Employee(1L,"louis");
        given( employeeService.deleteEmployee( any() ) ).willReturn( employee );

        mockMvc.perform( delete( "/api/v1/employees/{id}",1L ))
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "name").value( "louis" ) );
    }
    @Test
    public void should_return_employeeList_when_findAllEmployee() throws Exception {
        Employee employee1 = new Employee( 1L, "ALLEN" );
        Employee employee2 = new Employee( 2L, "june" );
        List <Employee> list = Arrays.asList( employee1, employee2 );
        given( employeeService.findAllEmployee() ).willReturn( list );

        mockMvc.perform( get( "/api/v1/employees" ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$", hasSize( 2 ) ) )
                .andExpect( jsonPath( "$[0].id", is( 1 ) ) )
                .andExpect( jsonPath( "$[0].name", is( "ALLEN" ) ) );


    }

}
