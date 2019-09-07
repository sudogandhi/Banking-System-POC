package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.RegistrationCO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.Login;
import com.dbs.banking.poc.bankingdemo.exceptions.UserAlreadyExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    CustomerRepository customerRepository;

    public String register(RegistrationCO registrationCO) throws UserAlreadyExistsException {

        if(this.usernameExists(registrationCO.getUsername())) {
            throw new UserAlreadyExistsException("User with the username ["+registrationCO.getUsername()+
                    "] already exists.");
        }

        if(this.userWithMobileExists(Long.parseLong(registrationCO.getMobileNo()))) {
            throw new UserAlreadyExistsException("User with the mobile no ["+registrationCO.getMobileNo()+
                    "] already exists");
        }
        if(this.userWithEmailExists(registrationCO.getEmail())) {
            throw new UserAlreadyExistsException("User with the email ["+registrationCO.getEmail()+
                    "] already exists");
        }


        return registrationCO.toString();
    }

    public boolean usernameExists(String username) {

        Optional<Customer> customer = customerRepository.findByUsername(username);
        Optional<Login> login = loginRepository.findByUsername(username);

        if(customer.isPresent() || login.isPresent()) {
            return true;
        }

        return false;
    }

    public boolean userWithMobileExists(Long mobileNo) {
        Optional<Customer> customer = customerRepository.findByMobileNo(mobileNo);

        if(customer.isPresent()) {
            return true;
        }

        return false;
    }
    public boolean userWithEmailExists(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        if(customer.isPresent()) {
            return true;
        }

        return false;
    }


}
