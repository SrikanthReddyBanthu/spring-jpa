package com.sri.springjpa.controller;

import com.sri.springjpa.entity.Customer;
import com.sri.springjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer add(@RequestBody Customer customer) {

        return customerService.addCustomer(customer);
    }

    @RequestMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable Long id) {

        return customerService.getCustomerById(id);
    }

    @RequestMapping("/get-all")
    public List<Customer> getAllCustomers() {
        return customerService.getCustomers();
    }

}
