package com.dbs.banking.poc.bankingdemo.entities;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class User extends BaseEntity {

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "lastName")
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "mobileNo")
    @NotNull
    private Long mobileNo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;
}
