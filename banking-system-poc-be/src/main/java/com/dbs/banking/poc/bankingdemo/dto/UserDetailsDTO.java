package com.dbs.banking.poc.bankingdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailsDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String role;
    private String email;
    private Long mobile;
    private String address;
    private String adharCard;
    private String panCard;
    private String customerStatus;
}
