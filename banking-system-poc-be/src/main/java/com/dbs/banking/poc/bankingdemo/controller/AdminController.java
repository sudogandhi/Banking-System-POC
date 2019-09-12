package com.dbs.banking.poc.bankingdemo.controller;

import com.dbs.banking.poc.bankingdemo.service.AdminService;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/listCustomers/{page}",produces =MediaType.APPLICATION_JSON_VALUE)
    public String fetchCustomers(@RequestHeader("Status") String customerStatus, @PathVariable("page")Integer page) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(adminService.fetchCustomers(customerStatus, page)));
        return objectMapper.writeValueAsString(adminService.fetchCustomers(customerStatus, page));
    }

    @GetMapping(value = "/listAccounts/{page}",produces =MediaType.APPLICATION_JSON_VALUE)
    public String fetchAccounts(@RequestHeader("Status") String accountStatus, @PathVariable("page")Integer page) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(adminService.fetchAccounts(accountStatus, page));
    }
}
