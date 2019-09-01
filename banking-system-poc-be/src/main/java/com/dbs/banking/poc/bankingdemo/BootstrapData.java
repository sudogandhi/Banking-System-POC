package com.dbs.banking.poc.bankingdemo;

import com.dbs.banking.poc.bankingdemo.entities.*;
import com.dbs.banking.poc.bankingdemo.repositories.BranchRepository;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BootstrapData {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BranchRepository branchRepository;

    public void createCustomer() {

        int i;
        for(i=0;i<20;i++) {
            Customer customer = new Customer();

            customer.setFirstName("fname"+i);
            customer.setLastName("lname"+i);
            customer.setUsername("username"+i);
            customer.setPassword("password"+i);
            customer.setCustomerStatus(i%2==0? CustomerStatus.APRROVED:CustomerStatus.REVIEW);
            customer.setEmail("email"+i+"@email.com");
            customer.setMobileNo(1234456778l);
            customer.setAdharCard("adhar"+i);
            customer.setPanCard("PANCARD"+i);
            Image adharImage = getImageObject("AdharCard"+i);
            customer.setAdharCardImage(adharImage);
            Image displayImage = getImageObject("Display"+i);
            customer.setDisplayImage(displayImage);
            Image panCardImage = getImageObject("PanCard"+i);
            customer.setPanCardImage(panCardImage);
            customer.setAddress(getAddressObject("address"+i));
            Set images = new HashSet();
            images.add(displayImage);
            images.add(adharImage);
            images.add(panCardImage);
            customer.setImages(images);
            customerRepository.save(customer);
        }


    }

    public Image getImageObject(String path) {
        Image image = new Image();
        image.setImagePath("Path/"+path);
        return image;
    }

    public Address getAddressObject(String add) {
        Address address = new Address();
        address.setCity("city"+add);
        address.setHouseNo("house no " + add);
        address.setPincode("pincode "+add);
        address.setState("state "+add);
        address.setStreet("street" + add);
        return address;
    }

    public void createAccount() {
        List<Customer> customers = customerRepository.findAll();
        int i;

        for(Customer customer : customers) {
            for(i = 0 ;i<2;i++) {
                Account account = new Account();
                account.setAccountNo(10000000+customer.getId());
                account.setAccountType(i==0?AccountType.CURRENT:AccountType.SAVING);
            }

        }
    }

    public Branch getBranch(String i) {
        Branch branch = branchRepository.findByIfscCode(i);
        if(branch == null) {
            branch = new Branch();
            branch.setBranchName("branch name"+i);
            branch.setIfscCode(i);
            branch.setAddress(this.getAddressObject("branch address"+i));
        }
        return branch;
    }
}
