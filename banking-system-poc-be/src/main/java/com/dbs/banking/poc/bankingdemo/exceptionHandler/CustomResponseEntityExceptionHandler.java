package com.dbs.banking.poc.bankingdemo.exceptionHandler;

import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.exceptions.*;
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

    @ExceptionHandler(TokenExpiredException.class)
    public final ResponseDTO handleTokenExpiredException(TokenExpiredException ex,WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public final ResponseDTO handleAccountNotFoundException(AccountNotFoundException ex,WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalAccountAccessException.class)
    public final ResponseDTO handleIllegalAccountAccessException(IllegalAccountAccessException ex, WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler({CustomerNotApprovedException.class})
    public final ResponseDTO handleCustomerNotApprovedException(CustomerNotApprovedException ex, WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler({AccountBlockedException.class,})
    public final ResponseDTO handleAccountBlockedException(AccountBlockedException ex, WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccountNotActivatedException.class)
    public final ResponseDTO handleAccountNotActivatedException(AccountNotActivatedException ex, WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler( InSufficientBalanceException.class)
    public final ResponseDTO handleInsufficientBalanceException(InSufficientBalanceException ex,WebRequest request) {
        return new ResponseDTO(ex.getMessage(),HttpStatus.FORBIDDEN);
    }
}
