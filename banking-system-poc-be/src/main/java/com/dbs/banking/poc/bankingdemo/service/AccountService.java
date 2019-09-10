package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.AccountCO;
import com.dbs.banking.poc.bankingdemo.entities.Account;
import com.dbs.banking.poc.bankingdemo.entities.AccountType;
import com.dbs.banking.poc.bankingdemo.entities.Branch;
import com.dbs.banking.poc.bankingdemo.exceptions.BranchNotFoundException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.AccountRepository;
import com.dbs.banking.poc.bankingdemo.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerService customerService;



    public String createAccount(AccountCO accountCO) throws BranchNotFoundException, UserNotExistsException {

        Account account=new Account();
        account.setAccountType(AccountType.valueOf(accountCO.getAccountType()));
        Branch branch = branchRepository.findById(accountCO.getBranchId()).orElse(null);

        if(branch == null) {
            throw new BranchNotFoundException("Branch does not exists.");
        }

        account.setCustomer(customerService.getLoggedInCustomer());

        account.setBalance(0.0);

        account.setBranch(branch);

        account.setActivated(false);

        account.setBlocked(false);

        accountRepository.save(account);

        return "Account Created";
    }
}
