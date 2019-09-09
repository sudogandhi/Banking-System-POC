package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.Image;
import com.dbs.banking.poc.bankingdemo.jwt.JwtTokenAuthorizationOncePerRequestFilter;
import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import com.dbs.banking.poc.bankingdemo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    JwtTokenAuthorizationOncePerRequestFilter jwtTokenAuthorizationOncePerRequestFilter;

    @Autowired
    ImageService imageService;

    @RequestMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/helloWorld1")
    public String helloWorld() {

        return jwtTokenAuthorizationOncePerRequestFilter.getLoggedInUsername();
    }

    @RequestMapping(value = "/adhar",method = { RequestMethod.POST, RequestMethod.PUT },
            consumes = { "multipart/form-data","image/jpeg","image/png" })
    ResponseDTO write(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(file);
        if(file == null) {
            return new ResponseDTO("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            imageService.uploadImage(file,1);
            return new ResponseDTO("success",HttpStatus.OK);
        }
    }
}
