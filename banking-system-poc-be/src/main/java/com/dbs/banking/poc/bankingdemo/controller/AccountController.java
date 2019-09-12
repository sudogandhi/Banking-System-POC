package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.co.AccountCO;
import com.dbs.banking.poc.bankingdemo.co.AccountNumberCO;
import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.entities.Account;
import com.dbs.banking.poc.bankingdemo.exceptions.BranchNotFoundException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.AccountRepository;
import com.dbs.banking.poc.bankingdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping(value = "/createAccount")
    public ResponseDTO createAccount(@RequestBody @Valid AccountCO accountCO) throws UserNotExistsException, BranchNotFoundException {

        String response = accountService.createAccount(accountCO);
        return new ResponseDTO(response, HttpStatus.CREATED);
    }

    @GetMapping(value="/getAllAccounts")                                   // to get all account details of the logged in customer
    public List<Account> getAllAccounts() throws UserNotExistsException {

        return accountService.getAllAccounts();
    }

    @GetMapping(value="/getAllAccountsNumber")                              //to get all accounts number int the bank
    public List<Long> getAllAccountsNumber() throws UserNotExistsException {
        return accountService.getAllAccountsNumber();
    }

    @GetMapping(value="/getAccountsNumber")                                 // to get all account number of the customer
    public List<Long> getAccountsNumber() throws UserNotExistsException {
        return accountService.getAccountsNumber();
    }

    @PostMapping(value="/getBalance")
    public Double getBalance(@RequestBody @Valid AccountNumberCO accountNumberCO){
        Double balance =  accountService.getBalance(accountNumberCO);
        return balance;
    }

    @PostMapping(value="/activateAccount")
    public String activateAccount(@RequestBody @Valid AccountNumberCO accountNumberCO){
        String response = accountService.activateAccount(accountNumberCO);
        return response;
    }


}
