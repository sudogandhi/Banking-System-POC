package com.dbs.banking.poc.bankingdemo.entities;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = "id")
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Set<Image> images;

    public User(String username, String firstName, String lastName, String email, String password, Long mobileNo, Address address, Set<Image> images) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.address = address;
        this.images = images;
    }

    public User(Long version, DateTime createdAt, DateTime updatedAt) {
        super(version, createdAt, updatedAt);
    }

    public User() {
    }
}
