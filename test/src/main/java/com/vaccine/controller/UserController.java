package com.vaccine.controller;


import com.vaccine.model.User;
import com.vaccine.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }


}
