package com.example.demo.one_to_n.service;

import com.example.demo.one_to_n.entity.Company;

import java.util.List;

public interface CompanyService {
    public Company addCompany(Company company);
    public List<Company> findAllCompany();
    public Company updateCompany(Company company);
    public Company deleteCompany(Long id);
}
