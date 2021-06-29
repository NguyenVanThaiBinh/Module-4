package com.example.demo.controller;

import java.util.List;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.model.Province;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RestController

public class EmployeeController {
    @Autowired
    EmployeeService service;

    @Autowired
    ProvinceService provinceService;

    @GetMapping("/employees")
    public ModelAndView listCustomers() {
        System.out.println("Here!!!!!!!!!!");
        List<EmployeeEntity> customers = service.getAllEmployees();
        List<Province> provinceList = provinceService.getAllProvince();
        ModelAndView modelAndView = new ModelAndView("EmployeeList");
        modelAndView.addObject("EmployeeEntity", new EmployeeEntity());
        modelAndView.addObject("Province", provinceList);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) throws RecordNotFoundException {

        System.out.println("Create Done!!!");
        String firstName = employeeEntity.getFirstName();
        String lastName = employeeEntity.getLastName();
        String email = employeeEntity.getEmail();
        Long province_id = employeeEntity.getProvince().getId();
        Province province = employeeEntity.getProvince();

//        service.createEmployee(employeeEntity);
        System.out.println("Id is: " + province.getName());
// Chua hieu vi sao getName lai ra ID??????
        Province province1 = provinceService.findById(Long.parseLong(province.getName()));

        EmployeeEntity employeeEntity1 = new EmployeeEntity(province1,firstName,lastName,email);
                service.createEmployee(employeeEntity1);
        System.out.println("Id is: " + province1.getName());
        return employeeEntity;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
//            throws RecordNotFoundException {
//        EmployeeEntity entity = service.getEmployeeById(id);
//
//        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee)
//            throws RecordNotFoundException {
//        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
//        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
//            throws RecordNotFoundException {
//        service.deleteEmployeeById(id);
//        return HttpStatus.FORBIDDEN;
//    }

}