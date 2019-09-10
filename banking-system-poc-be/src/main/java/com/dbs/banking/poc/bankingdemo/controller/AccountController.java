package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.co.AccountCO;
import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.exceptions.BranchNotFoundException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/createAccount")
    public ResponseDTO createAccount(@RequestBody @Valid AccountCO accountCO) throws UserNotExistsException, BranchNotFoundException {

        String response = accountService.createAccount(accountCO);
        return new ResponseDTO(response, HttpStatus.CREATED);
    }
}
