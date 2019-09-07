package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.RegistrationCO;
import com.dbs.banking.poc.bankingdemo.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public String register(RegistrationCO registrationCO) throws UserAlreadyExistsException {
        String result = "";
        if(registrationCO.getUsername().equals("ggandhi27")) {
            throw new UserAlreadyExistsException("User with the given name already exists");
        }
        return registrationCO.toString();
    }
}
