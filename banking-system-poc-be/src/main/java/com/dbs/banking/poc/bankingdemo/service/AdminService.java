package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.dto.CustomerDTO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.CustomerStatus;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.repositories.LoginRepository;
import com.dbs.banking.poc.bankingdemo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public String fetchCustomers(String customerStatus, Integer page) {
        List<Customer> customerList = null;
        Page<Customer> customerPage;
        PageRequest pageRequest = new PageRequest(page,5,new Sort(Sort.Direction.ASC,"id"));
        if("ALL".equals(customerStatus)) {
            customerPage= customerRepository.findAll(pageRequest);
        }
        else {
            customerPage = customerRepository.findByCustomerStatus(CustomerStatus.valueOf(customerStatus),
                    pageRequest);
        }
        if(customerPage.hasContent()) {
            customerList = customerPage.getContent();
        }
        return this.getCustomerDTO(customerList).toString();
    }

    public List<CustomerDTO> getCustomerDTO(List<Customer> customerList) {
        String downloadAdharUrl = "http://localhost:8089/download/adhar/";
        String downloadPanUrl = "http://localhost:8089/download/pan/";
        List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
        for(Customer customer: customerList) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setUsername(customer.getUsername());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setMobile(customer.getMobileNo());
            customerDTO.setAddress(customer.getAddress().toString());
            customerDTO.setAdharCardNo(customer.getAdharCard());
            customerDTO.setPanCardNo(customer.getPanCard());
            customerDTO.setCustomerStatus(customer.getCustomerStatus().name());
            customerDTO.setAdharCardImage(downloadAdharUrl+customer.getUsername());
            customerDTO.setPanCardImage(downloadPanUrl+customer.getUsername());
            customerDTOList.add(customerDTO);
        }
        System.out.println(customerDTOList);
        return customerDTOList;
    }
}
