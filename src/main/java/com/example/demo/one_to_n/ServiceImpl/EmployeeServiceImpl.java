package com.example.demo.one_to_n.ServiceImpl;

import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.entity.Employee;
import com.example.demo.one_to_n.repository.CompanyRepository;
import com.example.demo.one_to_n.repository.EmployeeRepository;
import com.example.demo.one_to_n.service.CompanyService;
import com.example.demo.one_to_n.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List <Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById( id ).get();
        employeeRepository.delete( employee );
        return employee;
    }
}
