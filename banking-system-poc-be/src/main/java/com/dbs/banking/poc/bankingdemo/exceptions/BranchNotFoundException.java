package com.dbs.banking.poc.bankingdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class BranchNotFoundException extends Exception {

    public BranchNotFoundException(String s) {
        super(s);
    }
}
