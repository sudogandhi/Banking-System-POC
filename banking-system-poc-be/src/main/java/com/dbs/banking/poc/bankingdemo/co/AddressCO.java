package com.dbs.banking.poc.bankingdemo.co;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressCO {

    private String city;

    private String state;

    private String pincode;

    private String houseNo;

    private String street;
}
