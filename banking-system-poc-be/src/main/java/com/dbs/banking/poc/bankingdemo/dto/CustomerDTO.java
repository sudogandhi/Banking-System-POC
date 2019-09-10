package com.dbs.banking.poc.bankingdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Long mobile;
    private String address;
    private String adharCardNo;
    private String panCardNo;
    private String customerStatus;
    private String adharCardImage;
    private String panCardImage;
}
