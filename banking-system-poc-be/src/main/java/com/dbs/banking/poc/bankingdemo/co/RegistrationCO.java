package com.dbs.banking.poc.bankingdemo.co;

import com.dbs.banking.poc.bankingdemo.validations.annontations.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationCO {

    @NotNull
    String firstname;

    @NotNull
    String lastname;

    @NotNull
    @Email
    String email;

    @NotNull
    String username;

    @NotNull
    String password;

    @NotNull
    @Mobile
    String mobileNo;

    @NotNull
    String panCard;

    @NotNull
    String adharCard;

}
