package com.java.controller;

import com.java.model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @RequestMapping("/test1/{id}")
//    public String test1(@PathVariable("id") int id, Model model) {
//        model.addAttribute("id", id);
//        return "test1";
//    }
//    @RequestMapping("/test2/{id}/{name}")
//    public String test2(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
//        model.addAttribute("id", id);
//        model.addAttribute("name", name);
//        return "test2";
//    }

//    @RequestMapping("/test3")

    @PostMapping("/test3")
    public ModelAndView test3(@RequestParam("id") int id,@RequestParam("name") String name,  Model model) {

        ModelAndView modelAndView = new ModelAndView("test3");

        Test t1 = new Test(id, name);
        modelAndView.addObject("t1", t1);

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return modelAndView;
    }
}


