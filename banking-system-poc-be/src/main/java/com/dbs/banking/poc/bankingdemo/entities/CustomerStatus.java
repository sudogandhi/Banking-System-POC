package com.dbs.banking.poc.bankingdemo.entities;

public enum CustomerStatus {
    REVIEW("REVIEW"), APRROVED("APPROVED"), REJECTED("REJECTED"),NEW("NEW");

    private final String status;

    CustomerStatus(String status) {
        this.status = status;
    }
}
