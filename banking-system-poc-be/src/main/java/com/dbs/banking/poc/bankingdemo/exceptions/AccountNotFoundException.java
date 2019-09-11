package com.dbs.banking.poc.bankingdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends javax.security.auth.login.AccountNotFoundException {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
