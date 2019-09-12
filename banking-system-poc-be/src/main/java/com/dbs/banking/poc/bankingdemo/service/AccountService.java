package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.AccountCO;
import com.dbs.banking.poc.bankingdemo.co.AccountNumberCO;
import com.dbs.banking.poc.bankingdemo.entities.*;
import com.dbs.banking.poc.bankingdemo.exceptions.BranchNotFoundException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.AccountRepository;
import com.dbs.banking.poc.bankingdemo.repositories.BranchRepository;
import com.dbs.banking.poc.bankingdemo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository  transactionRepository;

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
        account.setBalance((double) 50000);
        account.setAccountNo(accountRepository.nextAccountNo());
        accountRepository.save(account);

        return "Account Created";
    }

    public List<Account> getAllAccounts() throws UserNotExistsException {

        Customer customer=customerService.getLoggedInCustomer();
        return accountRepository.findAllByCustomer(customer);
    }

    public List<Long> getAllAccountsNumber() throws UserNotExistsException {
        Customer customer=customerService.getLoggedInCustomer();
        return accountRepository.getAllAccountsNumber();
    }

    public List<Long> getAccountsNumber() throws UserNotExistsException {

        Customer customer=customerService.getLoggedInCustomer();
        return accountRepository.getAccountsNumber(customer);
    }

    public Double getBalance(AccountNumberCO accountNumberCO) {
        return accountRepository.findBalanceById(accountNumberCO.getAccountNo());
    }

    public String activateAccount(AccountNumberCO accountNumberCO) {
        Account account=accountRepository.findByAccountNo(accountNumberCO.getAccountNo());
        account.setActivated(true);
        return "Account Activated";

    }

    public List<Transaction> allTransaction() {
        return transactionRepository.findAll();
    }
}
