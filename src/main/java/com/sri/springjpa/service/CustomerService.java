package com.sri.springjpa.service;

import com.sri.springjpa.entity.CustomerDetails;
import com.sri.springjpa.entity.PersonalDetails;
import com.sri.springjpa.model.CustomerDetailsModel;
import com.sri.springjpa.model.CustomerModel;
import com.sri.springjpa.model.PersonalDetailsModel;
import com.sri.springjpa.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerDetailsRepository customerRepository;

    public List<CustomerModel> getCustomers() {
        List<CustomerDetails> customDetails = customerRepository.findAll();
        return customDetails.stream().map(customer -> getCustomerModel(customer)).collect(Collectors.toList());
    }

    public CustomerModel getCustomerById(Long id) {
        Optional<CustomerDetails> customerDetails = customerRepository.findById(id);
        if (customerDetails.isPresent()) {
            return getCustomerModel(customerDetails.get());
        }
        return null;
    }

    public List<CustomerModel> getCustomerByName(String name) {
        List<CustomerDetails> customDetails = customerRepository.findByName(name);
        return customDetails.stream().map(customer -> getCustomerModel(customer)).collect(Collectors.toList());
    }

    public CustomerDetails addCustomer(CustomerModel customer) {

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setName(customer.getCustomerDetails().getName());

        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setMobile(customer.getPersonalDetails().getMobile());
        personalDetails.setEmail(customer.getPersonalDetails().getEmail());
        customerDetails.setPersonalDetails(personalDetails);

        return customerRepository.save(customerDetails);
    }

    private CustomerModel getCustomerModel(CustomerDetails customerDetails) {

        CustomerModel customerModel = new CustomerModel();
        CustomerDetailsModel customerDetailsModel = new CustomerDetailsModel();
        customerDetailsModel.setName(customerDetails.getName());

        PersonalDetailsModel personalDetailsModel = new PersonalDetailsModel();
        personalDetailsModel.setMobile(customerDetails.getPersonalDetails().getMobile());
        personalDetailsModel.setEmail(customerDetails.getPersonalDetails().getEmail());

        customerModel.setCustomerDetails(customerDetailsModel);
        customerModel.setPersonalDetails(personalDetailsModel);
        return customerModel;
    }

}
