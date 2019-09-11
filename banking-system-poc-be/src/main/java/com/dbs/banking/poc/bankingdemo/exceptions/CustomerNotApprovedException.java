package com.dbs.banking.poc.bankingdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CustomerNotApprovedException extends Exception {
    public CustomerNotApprovedException(String message) {
        super(message);
    }
}
