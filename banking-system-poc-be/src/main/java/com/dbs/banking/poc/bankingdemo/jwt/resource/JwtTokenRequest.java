package com.dbs.banking.poc.bankingdemo.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY4MzExNDIzLCJpYXQiOjE1Njc3MDY2MjN9.pXVJCfhvFDxdaaNTrt2bikQ3fnZs8pGnAjeN4NJyNldwWJcR0Lg5gh5UYqAh8kS7J7O8hcRpdBdnP65RkO-K-Q"
//    }

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
