package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "account")
@ToString
public class Account extends BaseEntity {

    @Column(name = "accountNo", unique = true)
    private long accountNo;

//    @Column(name = "userId")
//    private Long userId;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "isBlocked", columnDefinition = "boolean default true")
    private boolean isBlocked;
//
//    @Column(name = "branchId")
//    private Long branchId;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Branch branch;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "isActivated", columnDefinition = "boolean default false")
    private boolean isActivated;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "sender")
    @JoinTable(name = "sent_transactions",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "transaction_id", referencedColumnName = "id")})
    private Set<Transaction> sentTransactions;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "receiver")

    @JoinTable(name = "received_transactions",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "transaction_id", referencedColumnName = "id")})
    private Set<Transaction> receivedTransactions;

    public boolean getIsActivated() {
        return this.isActivated;
    }

    public boolean getIsBlocked() {
        return this.isBlocked;
    }
}
