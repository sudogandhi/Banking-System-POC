package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@ToString
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name  = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "houseNo")
    private String houseNo;

    @Column(name = "street")
    private String street;
}
