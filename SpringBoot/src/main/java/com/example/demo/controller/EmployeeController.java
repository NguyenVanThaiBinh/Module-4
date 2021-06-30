package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

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
        List<EmployeeEntity> employeeEntityList = service.getAllEmployees();
        List<Province> provinceList = provinceService.getAllProvince();
        ModelAndView modelAndView = new ModelAndView("EmployeeList");
        modelAndView.addObject("EmployeeEntity", new EmployeeEntity());
        modelAndView.addObject("ListEmployee", employeeEntityList);
        modelAndView.addObject("Province", provinceList);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity)
            throws RecordNotFoundException {


        System.out.println("Create Done!!!");
        String firstName = employeeEntity.getFirstName();
        String lastName = employeeEntity.getLastName();
        String email = employeeEntity.getEmail();

        Province province = employeeEntity.getProvince();


        Province province1 = provinceService.findById(province.getId());
        EmployeeEntity employeeEntity1 = new EmployeeEntity(province1, firstName, lastName, email);
        service.createEmployee(employeeEntity1);
        employeeEntity.setId(employeeEntity1.getId());
        employeeEntity.getProvince().setName(province1.getName());
//
        return employeeEntity;
    }

    @PostMapping("/delete/{id}")
    public void deleteCustomer(@RequestParam("id") long id) throws RecordNotFoundException {
        System.out.println("Da~ xoa!!!!!!!!!!!!!!");
        service.deleteEmployeeById(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public EmployeeEntity editCustomer(@RequestBody Long id) throws RecordNotFoundException {
        System.out.println("Edit part 1 came here!!!");
        EmployeeEntity customer = service.getEmployeeById(id);

        return customer;
    }

    @RequestMapping(value = "/edit-customer", method = RequestMethod.POST)
    public EmployeeEntity editCustomer(@RequestBody EmployeeEntity employeeEntity) throws RecordNotFoundException {
//        Get new Value
        Long employee_id = employeeEntity.getId();
        String firstName = employeeEntity.getFirstName();
        String lastName = employeeEntity.getLastName();
        String email = employeeEntity.getEmail();
        Province province = employeeEntity.getProvince();
        Province province1 = provinceService.findById(province.getId());

//      Set new value
        EmployeeEntity employeeEntity1 = service.getEmployeeById(employee_id);
        employeeEntity1.setFirstName(firstName);
        employeeEntity1.setLastName(lastName);
        employeeEntity1.setEmail(email);
        employeeEntity1.setProvince(province);
        employeeEntity1.getProvince().setName(province1.getName());

        System.out.println("Edit part 2 came here!!!");
        return employeeEntity1;
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