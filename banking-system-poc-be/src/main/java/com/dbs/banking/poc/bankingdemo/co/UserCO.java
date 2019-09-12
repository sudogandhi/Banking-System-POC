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
public class UserCO {
    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @NotNull
    @Email
    String email;

//    @NotNull
//    String username;

    @NotNull
    Long mobileNo;

}
