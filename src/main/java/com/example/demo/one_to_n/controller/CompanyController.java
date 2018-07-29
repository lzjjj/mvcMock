package com.example.demo.one_to_n.controller;


import com.example.demo.one_to_n.ServiceImpl.CompanyServiceImpl;
import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.entity.Employee;
import com.example.demo.one_to_n.repository.CompanyRepository;
import com.example.demo.one_to_n.repository.EmployeeRepository;
import com.example.demo.one_to_n.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

//    @Autowired
//    private EmployeeRepository employeeRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company) {
        return companyService.addCompany( company );
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Company> findAll() {
        return companyService.findAllCompany();
    }

    @Transactional
    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company delete(@PathVariable Long id) {
        return companyService.deleteCompany( id );
    }


    @Transactional
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public Optional <Company> findById(@PathVariable Long id) {
        return companyService.findACompany( id );
    }
//
//    @Transactional
//    @DeleteMapping(path = "/employee/{Eid}", produces = MediaType.APPLICATION_JSON_VALUE)
//
//    public ResponseEntity deleteEmployee(@PathVariable Long Eid) {
//        Employee employee = employeeRepository.findById( Eid ).get();
//        employeeRepository.delete( employee );
//        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
//    }
//
//    @Transactional
//    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Employee> getEmployees() {
//        return employeeRepository.findAll();
//    }
}
