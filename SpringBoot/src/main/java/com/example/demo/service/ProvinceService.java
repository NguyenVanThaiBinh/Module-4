package com.example.demo.service;


import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.Province;
import com.example.demo.repository.ProvinceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {

    @Autowired
    ProvinceRespository provinceRespository;

    public List<Province> getAllProvince()
    {
        List<Province> employeeList = provinceRespository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Province>();
        }
    }

    public void createProvince(Province entity) throws RecordNotFoundException {
        entity = provinceRespository.save(entity);
    }

    public Province findById(long parseLong) {

     Province province =   provinceRespository.getById(parseLong);
     return province;
    }
}
