package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.co.UserCO;
import com.dbs.banking.poc.bankingdemo.dto.ResponseDTO;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.User;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.service.LoginService;
import com.dbs.banking.poc.bankingdemo.service.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @PutMapping(value="/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserCO userCO) throws UserNotExistsException {
        String response=userService.updateUser(userCO);

        return new ResponseDTO(response, HttpStatus.CREATED);

    }

    @GetMapping(value = "/getLoggedInUserRole", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO getLoggedInUserRole() {

        return new ResponseDTO("{\"role\" : \""+loginService.getCurrentLoggedInUser().getRole().getRole()+"\"}",HttpStatus.OK);
    }


}
