package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.AddressCO;
import com.dbs.banking.poc.bankingdemo.entities.Address;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.jwt.JwtTokenAuthorizationOncePerRequestFilter;
import com.dbs.banking.poc.bankingdemo.repositories.AddressRepository;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    JwtTokenAuthorizationOncePerRequestFilter jwtTokenAuthorizationOncePerRequestFilter;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;


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

    @Transactional
    public String addAddress(AddressCO addressCO,Customer customer) {

        Address address=new Address();
        address.setCity(addressCO.getCity());
        address.setPincode(addressCO.getPincode());
        address.setHouseNo(addressCO.getHouseNo());
        address.setState(addressCO.getState());
        address.setStreet(addressCO.getStreet());
        addressRepository.save(address);

        customer.setAddress(address);
        customerRepository.save(customer);
        return "Address successfully Added";
    }
}
