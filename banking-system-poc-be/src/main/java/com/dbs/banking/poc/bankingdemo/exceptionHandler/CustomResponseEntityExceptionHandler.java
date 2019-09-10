package com.dbs.banking.poc.bankingdemo.exceptionHandler;

import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.exceptions.BranchNotFoundException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseDTO handleUserAlreadyExistsException(UserAlreadyExistsException ex, WebRequest request) {
        return new ResponseDTO(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BranchNotFoundException.class)
    public final ResponseDTO handleBranchNotFoundException(BranchNotFoundException ex, WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.NO_CONTENT);
    }
}
