package com.dbs.banking.poc.bankingdemo.co;

import com.dbs.banking.poc.bankingdemo.validations.annontations.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "RegistrationCO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
