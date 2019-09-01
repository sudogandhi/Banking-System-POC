package com.dbs.banking.poc.bankingdemo;

import com.dbs.banking.poc.bankingdemo.entities.*;
import com.dbs.banking.poc.bankingdemo.repositories.AccountRepository;
import com.dbs.banking.poc.bankingdemo.repositories.BranchRepository;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class BootstrapData {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    AccountRepository accountRepository;

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
        createBranch();
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

        Long n = 1000l;
        for(Customer customer : customers) {
//            Set<Account> customerAccounts = customer.getAccounts();
//            if(customerAccounts == null) {
//                customerAccounts = new HashSet<Account>();
//            }
            for(i = 0 ;i<4;i++) {
                Account account = new Account();
                account.setAccountNo(n++);
                account.setAccountType(i==0?AccountType.CURRENT:AccountType.SAVING);
                account.setActivated(true);
                account.setBalance(5744.99);
                account.setBlocked(false);
                Branch branch = branchRepository.findByIfscCode(""+i);
                account.setBranch(branch);
                account.setCustomer(customer);

                accountRepository.save(account);
//                Set<Account> accounts = branch.getAccounts();
//                if(accounts == null) {
//                    accounts = new HashSet<Account>();
//                }
//                accounts.add(account);
//                branch.setAccounts(accounts);
//                branchRepository.save(branch);
//                customerAccounts.add(account);
            }
//            customer.setAccounts(customerAccounts);
//            customerRepository.save(customer);
        }
    }

    public void createBranch() {
        for(int i = 0;i<4;i++) {
            Branch branch = new Branch();
            branch.setAddress(this.getAddressObject("branch address "+i));
            branch.setIfscCode(""+i);
            branch.setBranchName("branch name "+i);
            branchRepository.save(branch);
        }
        createAccount();
    }
}
