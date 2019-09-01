package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "customer")
@EqualsAndHashCode(callSuper = false)
public class Customer extends  User{

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    @Column(name = "adharCard")
    private String adharCard;

    @Column(name = "panCard")
    private String panCard;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "displayImage", referencedColumnName = "id")
    private Image displayImage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "panCardImage", referencedColumnName = "id")
    private Image panCardImage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "adharCardImage", referencedColumnName = "id")
    private Image adharCardImage;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private Set<Account> accounts;

    public Customer(String username, String firstName, String lastName, String email, String password, Long mobileNo, Address address, Set<Image> images) {
        super(username, firstName, lastName, email, password, mobileNo, address, images);
    }

    public Customer(Long version, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(version, createdAt, updatedAt);
    }

    public Customer() {
    }
}
