package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.RegistrationCO;
import com.dbs.banking.poc.bankingdemo.email.EmailServiceImpl;
import com.dbs.banking.poc.bankingdemo.entities.*;
import com.dbs.banking.poc.bankingdemo.exceptions.UserAlreadyExistsException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.repositories.LoginRepository;
import com.dbs.banking.poc.bankingdemo.repositories.RoleRepository;
import com.dbs.banking.poc.bankingdemo.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    LoginService loginService;


    @Transactional
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

        Optional<Role> role = roleRepository.findByRole("CUSTOMER");

        Login login = new Login(registrationCO.getUsername(),encoder.encode(registrationCO.getPassword()),role.orElse(new Role("CUSTOMER")));

        Customer customer = new Customer();

        customer.setUsername(registrationCO.getUsername());
        customer.setPassword(encoder.encode(registrationCO.getPassword()));
        customer.setFirstName(registrationCO.getFirstname());
        customer.setLastName(registrationCO.getLastname());
        customer.setMobileNo(Long.parseLong(registrationCO.getMobileNo()));
        customer.setEmail(registrationCO.getEmail());
        customer.setCustomerStatus(CustomerStatus.NEW);

        customerRepository.save(customer);
        loginRepository.save(login);

        return "User created successfully.";
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


    @Transactional
    public void requestForgetPassword(String username) throws UserNotExistsException {
        String tokenString = UUID.randomUUID().toString();

        Token token = new Token();
        Login login = loginRepository.findByUsername(username).orElse(null);
        Customer customer = customerRepository.findByUsername(username).orElse(null);

        if(login == null || customer==null) {
            throw new UserNotExistsException("Username not found.");
        }
        else if("CUSTOMER".equals(login.getRole().getRole())) {

            token.setToken(tokenString);
            token.setLogin(login);

            tokenRepository.deleteAllByLogin(login);
            tokenRepository.save(token);

            String emailBody = "http://localhost:8089/resetPassword/"+tokenString+"\n" +
                    "Please click on the above link to reset your password.";
            String emailSubject = "Hi "+login.getUsername()+" reset password.";
            emailService.sendSimpleMessage(customer.getEmail(),emailSubject,emailBody);
        }
    }
}
