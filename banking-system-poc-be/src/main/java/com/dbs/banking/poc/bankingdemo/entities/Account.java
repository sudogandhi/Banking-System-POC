package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "account")
public class Account extends BaseEntity {

    @Column(name = "accountNo")
    private long accountNo;

    @Column(name = "customerId")
    private Long customerId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "isBlocked")
    private boolean isBlocked;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Branch banch;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "isActivated")
    private boolean isActivated;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId")
    private Set<Transaction> sentTransactions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverId")
    private Set<Transaction> receivedTransactions;


}
