package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "branch")
public class Branch extends BaseEntity {

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "ifscCode", unique = true)
    private String ifscCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "branchId")
    private Set<Account> accounts;
}
