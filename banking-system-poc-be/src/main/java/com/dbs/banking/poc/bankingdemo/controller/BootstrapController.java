package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.BootstrapData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootstrapController {

    @Autowired
    BootstrapData bootstrapData;

    @RequestMapping(value = "/bootstrapCustomer",method = RequestMethod.GET)
    public void bootstrapCustomer() {
        bootstrapData.createCustomer();
    }
}
