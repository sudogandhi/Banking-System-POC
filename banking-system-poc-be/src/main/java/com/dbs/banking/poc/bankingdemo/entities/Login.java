package com.dbs.banking.poc.bankingdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login extends BaseEntity {

    @Column(name = "username",unique = true)
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @ManyToOne
    Role role;


}
