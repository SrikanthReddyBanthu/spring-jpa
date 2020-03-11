package com.sri.springjpa.controller;
import com.sri.springjpa.entity.Customer;
import com.sri.springjpa.repository.CustomerRepository;
import com.sri.springjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/up")
    public String up() {

        return "Running application";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer add(@RequestBody Customer customer) {

        return customerRepository.save(customer);
    }

    @RequestMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable Long id) {

        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElse(null);
    }

    @RequestMapping("/get-all")
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

}
