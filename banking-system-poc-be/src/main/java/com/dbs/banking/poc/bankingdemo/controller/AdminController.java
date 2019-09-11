package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/listCustomers/{page}",produces =MediaType.APPLICATION_JSON_VALUE)
    public String fetchCustomers(@RequestHeader("Status") String customerStatus, @PathVariable("page")Integer page) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(adminService.fetchCustomers(customerStatus, page));
    }

    @GetMapping(value = "/listAccounts/{page}",produces =MediaType.APPLICATION_JSON_VALUE)
    public String fetchAccounts(@RequestHeader("Status") String accountStatus, @PathVariable("page")Integer page) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(adminService.fetchAccounts(accountStatus, page));
    }
}
