package com.example.demo.one_to_n.repository;

import com.example.demo.one_to_n.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
    public List<Company> findAll();


    @Query(name = "select * from company where name = ?1")
    public Company findByName(String name);
}
