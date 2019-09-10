package com.dbs.banking.poc.bankingdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class UserNotExistsException extends Exception{

    public UserNotExistsException(String message) {
        super(message);
    }
}
