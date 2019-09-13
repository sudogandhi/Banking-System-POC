package com.dbs.banking.poc.bankingdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

//    @Override
//    public String toString() {
//        return "{" +
//                " \"firstName\" : \"" + firstName + '\"' +
//                ", \"lastName\" : \"" + lastName + '\"' +
//                ", \"username\" : \"" + username + '\"' +
//                ", \"email\" : \"" + email + '\"' +
//                ", \"mobile\" : \"" + mobile + '\"' +
//                ", \"address\" : " + address + '\"' +
//                ", \"adharCardNo\" : " + adharCardNo + '\"' +
//                ", \"panCardNo\" : " + panCardNo + '\"' +
//                ", \"customerStatus\" : " + customerStatus + '\"' +
//                ", \"adharCardImage\" : " + adharCardImage + '\"' +
//                ", \"panCardImage\" : " + panCardImage + '\"' +
//                '}';
//    }
}
