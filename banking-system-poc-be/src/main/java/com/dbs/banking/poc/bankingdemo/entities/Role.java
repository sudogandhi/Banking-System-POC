package com.dbs.banking.poc.bankingdemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role extends BaseEntity{

    @Column(name = "role",unique = true)
    @NotNull
    private String role;

}
