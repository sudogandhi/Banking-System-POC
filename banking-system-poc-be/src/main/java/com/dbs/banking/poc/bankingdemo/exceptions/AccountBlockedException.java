package com.dbs.banking.poc.bankingdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccountBlockedException extends Exception {
    public AccountBlockedException(String message) {
        super(message);
    }
}
