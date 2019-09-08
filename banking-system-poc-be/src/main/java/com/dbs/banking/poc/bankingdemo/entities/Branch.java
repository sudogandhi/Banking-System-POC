package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "branch")
@ToString
public class Branch extends BaseEntity {

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "ifscCode", unique = true)
    private String ifscCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Account> accounts = new HashSet<Account>();
}
