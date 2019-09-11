package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.co.SendMoneyCO;
import com.dbs.banking.poc.bankingdemo.entities.Account;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.Transaction;
import com.dbs.banking.poc.bankingdemo.exceptions.*;
import com.dbs.banking.poc.bankingdemo.repositories.AccountRepository;
import com.dbs.banking.poc.bankingdemo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public String transferMoney(SendMoneyCO sendMoneyCO) throws
            AccountNotFoundException,
            UserNotExistsException,
            IllegalAccountAccessException,
            CustomerNotApprovedException,
            AccountBlockedException,
            InSufficientBalanceException,
            AccountNotActivatedException {
        Account senderAccount = accountRepository.findByAccountNo(sendMoneyCO.getSender());
        validateSender(senderAccount);

        Account receiverAccount = accountRepository.findByAccountNo(sendMoneyCO.getReceiver());
        validateReceiver(receiverAccount);

        Customer customer = customerService.getLoggedInCustomer();
        checkIllegalAccountAccess(senderAccount,customer);

        isCustomerApproved(customer);
        isSenderAccountActivated(senderAccount);
        isSenderAccountBlocked(senderAccount);
        isReceiverAccountActivated(receiverAccount);
        isReceiverAccountBlocked(receiverAccount);
        haveSufficientBalance(senderAccount,sendMoneyCO.getAmount());

        Transaction transaction = new Transaction();

        transaction.setSender(senderAccount);
        transaction.setReceiver(receiverAccount);
        transaction.setAmountTransferred(sendMoneyCO.getAmount());
        transaction.setReceiverOldBalance(receiverAccount.getBalance());
        transaction.setSenderOldBalance(senderAccount.getBalance());

        transaction.setReceiverNewBalance(receiverAccount.getBalance()+sendMoneyCO.getAmount());
        transaction.setSenderNewBalance(senderAccount.getBalance()-sendMoneyCO.getAmount());
        transaction.setChecked(false);

        senderAccount.setBalance(senderAccount.getBalance()-sendMoneyCO.getAmount());
        receiverAccount.setBalance(receiverAccount.getBalance()+sendMoneyCO.getAmount());

        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);

        transaction.setFailed(false);
        transactionRepository.save(transaction);

        return "Transaction Successfully completed.";
    }

    private void haveSufficientBalance(Account senderAccount, Double amount) throws InSufficientBalanceException {
        if(senderAccount.getBalance() - amount < 0) {
            throw new InSufficientBalanceException("Insufficient Balance");
        }
    }

    @Transactional
    public void isReceiverAccountActivated(Account receiverAccount) throws AccountNotActivatedException {
        if(!receiverAccount.getIsActivated()) {
            throw new AccountNotActivatedException("Receiver's account is not activated.");
        }
    }

    @Transactional
    public void isReceiverAccountBlocked(Account receiverAccount) throws AccountBlockedException {
        if(receiverAccount.getIsBlocked()) {
            throw new AccountBlockedException("Receiver's account is blocked.");
        }
    }

    @Transactional
    public void isSenderAccountActivated(Account senderAccount) throws AccountNotActivatedException {
        if(!senderAccount.getIsActivated()) {
            throw new AccountNotActivatedException("Sender's account is not activated.");
        }
    }

    @Transactional
    public void isSenderAccountBlocked(Account senderAccount) throws AccountBlockedException {
        if(senderAccount.getIsBlocked()) {
            throw new AccountBlockedException("Sender's account is blocked.");
        }
    }

    @Transactional
    public void isCustomerApproved(Customer customer) throws CustomerNotApprovedException {
        if(!"APPROVED".equals(customer.getCustomerStatus().name())) {
            throw new CustomerNotApprovedException("Customer's account is not activated.");
        }
    }


    @Transactional
    public void checkIllegalAccountAccess(Account senderAccount, Customer customer) throws IllegalAccountAccessException {
        if(!customer.getUsername().equals(senderAccount.getCustomer().getUsername())) {
            throw new IllegalAccountAccessException("Not allowed to transfer money. Illegal account access.");
        }

    }

    @Transactional
    public void validateSender(Account senderAccount) throws AccountNotFoundException {
        if(senderAccount == null) {
            throw new AccountNotFoundException("Account number for sender is invalid.");
        }

    }

    @Transactional
    public void validateReceiver(Account receiverAccount) throws AccountNotFoundException {
        if(receiverAccount == null) {
            throw new AccountNotFoundException("Account number for receiver is invalid.");
        }

    }

}
