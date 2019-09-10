package com.dbs.banking.poc.bankingdemo.entities;

public enum CustomerStatus {
    APPROVED("APPROVED"),NEW("NEW");

    private final String status;

    CustomerStatus(String status) {
        this.status = status;
    }
}
