package com.example.demo.one_to_n.ServiceImpl;

import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.repository.CompanyRepository;
import com.example.demo.one_to_n.repository.EmployeeRepository;
import com.example.demo.one_to_n.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Company addCompany(Company company) {
        company.getEmployees().stream()
                .forEach( employee -> employee.setCompany( company ) );
        return companyRepository.save( company );
    }

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Company company) {
        company.getEmployees().stream()
                .filter( employee -> employee.getCompany() == null )
                .forEach( employee -> employee.setCompany( company ) );
       return companyRepository.save( company );
    }
}
