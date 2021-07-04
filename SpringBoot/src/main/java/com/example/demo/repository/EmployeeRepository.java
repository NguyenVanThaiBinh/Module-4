package com.example.demo.repository;

import com.example.demo.model.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeeEntity, Long> {
    Page<EmployeeEntity> findAll(Pageable pageable);



}