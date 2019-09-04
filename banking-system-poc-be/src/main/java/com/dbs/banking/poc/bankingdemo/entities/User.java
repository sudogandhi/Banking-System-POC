package com.dbs.banking.poc.bankingdemo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = "id")
@ToString
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private Set<Image> images;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

    @ManyToOne
    Role role;

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

    public User(Long version, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(version, createdAt, updatedAt);
    }

    public User() {
    }

    public User(User user) {

    }
}
