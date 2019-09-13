package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.co.RegistrationCO;
import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.exceptions.TokenExpiredException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserAlreadyExistsException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody @Valid RegistrationCO registrationCO) throws UserAlreadyExistsException {

         String response = registrationService.register(registrationCO);

         return new ResponseDTO("{ \"message\" : \""+response+"\"}", HttpStatus.OK);
    }

    @PostMapping(value="/requestForgetPassword")
    public ResponseDTO requestForgetPassword(@RequestBody String username) throws UserNotExistsException {
        System.out.println(username);
        registrationService.requestForgetPassword(username);
        return new ResponseDTO("Link is sent to the email id",HttpStatus.OK);
    }

    @GetMapping(value="/activation/{token}")
    public void activateUser(@PathVariable String token) throws UserNotExistsException, TokenExpiredException {
        registrationService.activateUser(token);
    }
}
