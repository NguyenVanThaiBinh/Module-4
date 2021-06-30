package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(targetEntity = EmployeeEntity.class)
//    private List<EmployeeEntity> employeeEntity;

    public Province() {
    }

    public Province(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<EmployeeEntity> getCustomers() {
//        return employeeEntity;
//    }
//
//    public void setCustomers(List<EmployeeEntity> customers) {
//        this.employeeEntity = customers;
//    }
}
