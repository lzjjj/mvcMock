package com.example.demo;

import com.example.demo.one_to_n.controller.CompanyController;
import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.repository.CompanyRepository;
import com.example.demo.one_to_n.service.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTests {

//    @Autowired
//    private ApplicationContext applicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void should_return_company_when_addCompany() {
        List <Company> list = new ArrayList <>();
        Company company = new Company( 1, "jd" );
        given( companyService.addCompany( any() ) ).willReturn( company );
        try {
            mockMvc.perform( post( "/api/v1/companies" ).contentType( MediaType.APPLICATION_JSON_VALUE )
                    .content( mapper.writeValueAsString( company ) ) )
                    .andExpect( jsonPath( "name" ).value( "jd" ) );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void should_return_companyList_when_findAllCompany() throws Exception {
        Company company1 = new Company( 1, "jd" );
        Company company2 = new Company( 2, "alibaba" );
        List <Company> list = Arrays.asList( company1, company2 );
        given( companyService.findAllCompany() ).willReturn( list );

        mockMvc.perform( get( "/api/v1/companies" ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "$", hasSize( 2 ) ) )
                .andExpect( jsonPath( "$[0].id", is( 1 ) ) )
                .andExpect( jsonPath( "$[0].name", is( "jd" ) ) );


    }

    @Test
    public void should_return_company_when_updateCpmpany() throws Exception {
        Company company1 = new Company( 1, "ali" );
        given( companyService.updateCompany( any() ) ).willReturn( company1 );

        mockMvc.perform( put( "/api/v1/companies" ).contentType( MediaType.APPLICATION_JSON_VALUE )
                .content( mapper.writeValueAsString( company1 ) ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "name").value( "ali" ) );
    }

}
