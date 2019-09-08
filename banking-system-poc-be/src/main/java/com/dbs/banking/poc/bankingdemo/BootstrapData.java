package com.dbs.banking.poc.bankingdemo;

import com.dbs.banking.poc.bankingdemo.entities.*;
import com.dbs.banking.poc.bankingdemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void createRoles() {
        Role role = new Role("CUSTOMER");
        Role role1 = new Role("ADMIN");

        roleRepository.save(role);
        roleRepository.save(role1);
    }

    public void createCustomer() {
        this.createRoles();
        Role role = roleRepository.findByRole("CUSTOMER").orElse(new Role("CUSTOMER"));
        int i;
        for(i=0;i<20;i++) {
            Customer customer = new Customer();
            Login login = new Login();

            customer.setFirstName("fname"+i);
            customer.setLastName("lname"+i);
            customer.setUsername("username"+i);
            login.setUsername("username"+i);

            String password = passwordEncoder.encode("password"+i);
            customer.setPassword(password);
            login.setPassword(password);

            login.setRole(role);
            customer.setCustomerStatus(i%2==0? CustomerStatus.APRROVED:CustomerStatus.REVIEW);
            customer.setEmail("email"+i+"@email.com");
            customer.setMobileNo(1234456778l);
            customer.setAdharCard("adhar"+i);
            customer.setPanCard("PANCARD"+i);
//            customer.setRole(role);
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
            loginRepository.save(login);
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
