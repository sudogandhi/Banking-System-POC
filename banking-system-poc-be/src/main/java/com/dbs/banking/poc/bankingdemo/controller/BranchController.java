package com.dbs.banking.poc.bankingdemo.controller;


import com.dbs.banking.poc.bankingdemo.entities.Branch;
import com.dbs.banking.poc.bankingdemo.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BranchController {

    @Autowired
    BranchRepository branchRepository;

    @RequestMapping("/getAllBranchesName")
    public List<String> getBranchesName() {
        return branchRepository.getBranchNames();
    }

}
