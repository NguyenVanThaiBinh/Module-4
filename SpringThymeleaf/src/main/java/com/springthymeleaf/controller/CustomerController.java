package com.springthymeleaf.controller;
import com.springthymeleaf.DAO.CustomerService;
import com.springthymeleaf.DAO.CustomerServiceImpl;
import com.springthymeleaf.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model) {

        List customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirAttrs) {
        customer.setId((int)(Math.random() * 100));
        customerService.save(customer);
        redirAttrs.addFlashAttribute("success", "Save successfully!");

        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }
    @PostMapping("/customer/update")
    public String update(Customer customer, RedirectAttributes redirAttrs) {
        customerService.update(customer.getId(), customer);
        redirAttrs.addFlashAttribute("success", "Edit successfully!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }
    @PostMapping("/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}