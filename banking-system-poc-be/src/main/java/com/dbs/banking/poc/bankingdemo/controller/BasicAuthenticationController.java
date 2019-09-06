package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.config.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicAuthentication() {
        return new AuthenticationBean("You are authenticated.");
    }
}
