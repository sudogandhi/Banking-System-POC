package com.dbs.banking.poc.bankingdemo.service;
import com.dbs.banking.poc.bankingdemo.co.UserCO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.CustomerStatus;
import com.dbs.banking.poc.bankingdemo.entities.User;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.dto.UserDetailsDTO;
import com.dbs.banking.poc.bankingdemo.entities.Address;
import com.dbs.banking.poc.bankingdemo.entities.Login;
import org.springframework.http.HttpStatus;
@Service
public class UserService {
    @Autowired
    LoginService loginService;
    @Autowired
    CustomerRepository customerRepository;
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

            userDetailsDTO.setPanCard(customer.getPanCard());
            userDetailsDTO.setAdharCard(customer.getAdharCard());
            userDetailsDTO.setMobile(customer.getMobileNo());
            userDetailsDTO.setCustomerStatus(customer.getCustomerStatus().name());
        }
        return userDetailsDTO;
    }
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