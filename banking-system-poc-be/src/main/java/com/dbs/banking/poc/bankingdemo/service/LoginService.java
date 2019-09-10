package com.dbs.banking.poc.bankingdemo.service;

import com.dbs.banking.poc.bankingdemo.entities.Login;
import com.dbs.banking.poc.bankingdemo.jwt.JwtTokenAuthorizationOncePerRequestFilter;
import com.dbs.banking.poc.bankingdemo.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    JwtTokenAuthorizationOncePerRequestFilter jwt;

    @Autowired
    LoginRepository loginRepository;

    public Login getCurrentLoggedInUser() {
        String username = jwt.getLoggedInUsername();

        Login login = loginRepository.findByUsername(username).orElse(null);

        if(login == null) {
            throw new UsernameNotFoundException("Username not found.");
        }

        return login;
    }
}
