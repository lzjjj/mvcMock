package com.example.demo.one_to_n.service;

import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> findAllEmployee();
    public Employee deleteEmployee(Long id);
}
