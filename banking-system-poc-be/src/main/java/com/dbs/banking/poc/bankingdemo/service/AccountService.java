package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.AccountCO;
import com.dbs.banking.poc.bankingdemo.co.AccountNumberCO;
import com.dbs.banking.poc.bankingdemo.co.TransactionCO;
import com.dbs.banking.poc.bankingdemo.entities.*;
import com.dbs.banking.poc.bankingdemo.exceptions.BranchNotFoundException;
import com.dbs.banking.poc.bankingdemo.exceptions.UserNotExistsException;
import com.dbs.banking.poc.bankingdemo.repositories.AccountRepository;
import com.dbs.banking.poc.bankingdemo.repositories.BranchRepository;
import com.dbs.banking.poc.bankingdemo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
        System.out.println(account.getAccountNo());
        account.setActivated(true);
        accountRepository.save(account);
        return "Account Activated";

    }

    public List<Transaction> allTransaction() {
        return transactionRepository.findAll();
    }

    public List<Transaction> userTransactions(AccountNumberCO accountNumberCO) throws UserNotExistsException {
        Account account=accountRepository.findByAccountNo(accountNumberCO.getAccountNo());
        List<Transaction> result = transactionRepository.userTransactions(account);
        //Collections.reverse(result);
        return result;
    }

    public List<Transaction> lastTenTransactions(AccountNumberCO accountNumberCO) {
        Account account=accountRepository.findByAccountNo(accountNumberCO.getAccountNo());
        List<Transaction> result = transactionRepository.userTransactions(account);
        //Collections.reverse(result);
        return result.subList(0,Math.min(10,result.size()));

    }

    public List<Transaction> transactionBetweenDates(TransactionCO transactionCO) throws ParseException {
        Account account=accountRepository.findByAccountNo(transactionCO.getAccountNo());
//        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String fromDate = format.parse(transactionCO.getFromDate());
//        String toDate = format.parse(transactionCO.getToDate());
//        DateTimeFormatter formatrmatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime fromDate= (LocalDateTime) formatter.parse(transactionCO.getFromDate());
//        LocalDateTime toDate= (LocalDateTime) formatter.parse(transactionCO.getToDate());
//        System.out.println(fromDate + "   -   "+toDate);
//        List<Transaction> result=transactionRepository.transactionBetweenDates(fromDate,toDate);
//        for(Transaction r:result){
//            System.out.println(r.getCreatedAt());
//        }
        List<Transaction> result=transactionRepository.userTransactions(account);
        return result;
    }
}
