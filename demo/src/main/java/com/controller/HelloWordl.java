package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWordl {
    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name, ModelMap model){
        model.addAttribute("name",name);
        model.addAttribute("msg","Hello Binh Hu");
        return "hello";
    }
}
