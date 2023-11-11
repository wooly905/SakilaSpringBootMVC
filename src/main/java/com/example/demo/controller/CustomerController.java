package com.example.demo.controller;

import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer-list")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "/sakila/customer-list.html";
    }
}
