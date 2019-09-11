package com.dbs.banking.poc.bankingdemo.controller;


import com.dbs.banking.poc.bankingdemo.co.AddressCO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value="/customerDetails")
    public Customer userDetails() throws UserNotExistsException {
        Customer customer=customerService.getLoggedInCustomer();
        return customer;
    }

    @PutMapping(value="/addAddress")
    public String addAddress(AddressCO addressCO) throws UserNotExistsException {
        Customer customer=customerService.getLoggedInCustomer();
        String response=customerService.addAddress(addressCO,customer);
        return response;
    }
}
