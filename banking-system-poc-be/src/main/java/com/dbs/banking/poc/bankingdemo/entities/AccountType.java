package com.dbs.banking.poc.bankingdemo.entities;

public enum AccountType {
    SAVING("SAVING"), CURRENT("CURRENT");

    private final String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }
}
