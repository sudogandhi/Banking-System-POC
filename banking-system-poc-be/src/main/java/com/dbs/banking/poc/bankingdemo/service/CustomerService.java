package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.jwt.JwtTokenAuthorizationOncePerRequestFilter;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    JwtTokenAuthorizationOncePerRequestFilter jwtTokenAuthorizationOncePerRequestFilter;

    @Autowired
    CustomerRepository customerRepository;


    public Customer getLoggedInCustomer() throws UserNotExistsException {
        String username = jwtTokenAuthorizationOncePerRequestFilter.getLoggedInUsername();
        Optional<Customer> optionalCustomer = customerRepository.findByUsername(username);
        if(optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        else{
            throw new UserNotExistsException("User doesnot exists.");
        }

    }
}
