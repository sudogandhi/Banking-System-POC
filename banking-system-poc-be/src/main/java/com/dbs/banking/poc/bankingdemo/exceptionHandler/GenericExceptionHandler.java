package com.dbs.banking.poc.bankingdemo.exceptionHandler;

import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
@RestController
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseDTO genericExceptionHandler(Exception exception, WebRequest request) {
        return new ResponseDTO("Something went wrong. Please contact admin",
                HttpStatus.BAD_REQUEST);
    }
}
