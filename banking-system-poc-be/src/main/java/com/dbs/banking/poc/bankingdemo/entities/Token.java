package com.dbs.banking.poc.bankingdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Token extends BaseEntity {

    @Column(name = "token",unique = true)
    String token;

    @OneToOne
    Login login;
}
