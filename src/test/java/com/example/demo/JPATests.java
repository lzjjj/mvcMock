package com.example.demo;

import com.example.demo.one_to_n.entity.Company;
import com.example.demo.one_to_n.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class JPATests {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void should_return_company_when_findByName() {
        Company saveCompany = testEntityManager.persistFlushFind( new Company( 1L, "louis" ) );
        Company company =  companyRepository.findByName( "louis" );
        Assertions.assertThat( company.getName() ).isEqualTo( saveCompany.getName() );
        Assertions.assertThat( company.getId() ).isEqualTo( saveCompany.getId() );
    }
    @Test
    public void should_return_companyList_when_findAll() {
        Company saveCompany = testEntityManager.persistFlushFind( new Company( 1L, "louis" ) );
        Company company =  companyRepository.findByName( "louis" );
        Assertions.assertThat( company.getName() ).isEqualTo( saveCompany.getName() );
        Assertions.assertThat( company.getId() ).isEqualTo( saveCompany.getId() );
    }

}
