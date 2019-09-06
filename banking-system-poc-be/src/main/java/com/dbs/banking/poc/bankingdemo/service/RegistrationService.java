package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.RegistrationCO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public String register(RegistrationCO registrationCO) {
        String result = "";

        return registrationCO.toString();
    }
}
