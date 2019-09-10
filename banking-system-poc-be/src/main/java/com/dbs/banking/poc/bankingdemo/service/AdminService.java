package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.dto.CustomerDTO;
import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.CustomerStatus;
import com.dbs.banking.poc.bankingdemo.entities.Login;
import com.dbs.banking.poc.bankingdemo.entities.Role;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.repositories.LoginRepository;
import com.dbs.banking.poc.bankingdemo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseDTO fetchCustomers(String customerStatus) {

        List<Customer> customerList = null;

        if("ALL".equals(customerStatus)) {
            customerList = customerRepository.findAll();
        }
        else {
            customerList = customerRepository.findByCustomerStatus(CustomerStatus.valueOf(customerStatus));
        }
        return new ResponseDTO(customerList.toString(), HttpStatus.OK);
    }

//    public List<CustomerDTO> getCustomerDTO(List<Customer> customerList) {
//
//    }
}
