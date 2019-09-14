package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.co.SendMoneyCO;
import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.exceptions.*;
import com.dbs.banking.poc.bankingdemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseDTO transferMoney(@RequestBody SendMoneyCO sendMoneyCO) throws
            AccountNotFoundException,
            CustomerNotApprovedException,
            AccountNotActivatedException,
            UserNotExistsException,
            AccountBlockedException,
            InSufficientBalanceException,
            IllegalAccountAccessException {
        return new ResponseDTO(transactionService.transferMoney(sendMoneyCO), HttpStatus.OK);
    }

}
