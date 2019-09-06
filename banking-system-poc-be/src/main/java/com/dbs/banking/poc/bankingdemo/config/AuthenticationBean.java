package com.dbs.banking.poc.bankingdemo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationBean {

    private String message;

    @Override
    public String toString() {
        return "AuthenticationBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
