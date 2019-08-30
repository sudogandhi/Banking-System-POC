package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "branch")
public class Branch extends BaseEntity {

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "ifscCode")
    private String ifscCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;
}
