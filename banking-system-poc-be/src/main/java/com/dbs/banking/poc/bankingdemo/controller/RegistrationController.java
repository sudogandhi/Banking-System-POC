package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.co.RegistrationCO;
import com.dbs.banking.poc.bankingdemo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody @Valid RegistrationCO registrationCO) {

        return registrationService.register(registrationCO);
    }
}
