package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "account")
public class Account extends BaseEntity {

    @Column(name = "accountNo", unique = true)
    private long accountNo;

    @Column(name = "userId")
    private Long userId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "isBlocked", columnDefinition = "boolean default true")
    private boolean isBlocked;

    @Column(name = "branchId")
    private Long branchId;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "isActivated", columnDefinition = "boolean default false")
    private boolean isActivated;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId")
    private Set<Transaction> sentTransactions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverId")
    private Set<Transaction> receivedTransactions;


}
