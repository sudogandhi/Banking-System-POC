package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.UserCO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.CustomerStatus;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    public String updateUser(UserCO userCO) throws UserNotExistsException {
        Customer customer=customerService.getLoggedInCustomer();

        //customer.setUsername(userCO.getUsername());
        customer.setFirstName(userCO.getFirstName());
        customer.setLastName(userCO.getLastName());
        customer.setEmail(userCO.getEmail());
        customer.setMobileNo(userCO.getMobileNo());

        customerRepository.save(customer);

        return "User updated successfully.";
    }
}
