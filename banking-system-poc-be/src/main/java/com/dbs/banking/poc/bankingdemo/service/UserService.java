package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.dto.UserDetailsDTO;
import com.dbs.banking.poc.bankingdemo.entities.Address;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.Login;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    LoginService loginService;

    @Autowired
    CustomerService customerService;

    public UserDetailsDTO getLoggedInUserDetails() throws UserNotExistsException {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        Login login = loginService.getCurrentLoggedInUser();
        Customer customer = customerService.getLoggedInCustomer();

        if("ACCOUNT".equals(login.getRole().getRole())) {
            userDetailsDTO.setFirstName("ADMIN");
            userDetailsDTO.setLastName("");
            userDetailsDTO.setRole(login.getRole().getRole());
            userDetailsDTO.setUsername(login.getUsername());
        }
        else {
            userDetailsDTO.setFirstName(customer.getFirstName());
            userDetailsDTO.setLastName(customer.getLastName());
            userDetailsDTO.setRole(login.getRole().getRole());

            Address address = customer.getAddress();
            if(address != null) {
                userDetailsDTO.setAddress(address.toString());
            }

            userDetailsDTO.setUsername(login.getUsername());
            userDetailsDTO.setEmail(customer.getEmail());

            userDetailsDTO.setAdharCard(customer.getAdharCard());
            userDetailsDTO.setPanCard(customer.getPanCard());
            userDetailsDTO.setMobile(customer.getMobileNo());
            userDetailsDTO.setCustomerStatus(customer.getCustomerStatus().name());
        }
        return userDetailsDTO;
    }
}
