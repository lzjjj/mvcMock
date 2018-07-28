package com.example.demo.one_to_n.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "company")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @CreatedDate
    private ZonedDateTime create_time = ZonedDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    private List <Employee> employees;



    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(ZonedDateTime create_time) {
        this.create_time = create_time;
    }
    public List <Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List <Employee> employees) {
        this.employees = employees;
    }
}
