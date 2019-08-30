package com.dbs.banking.poc.bankingdemo;

import com.dbs.banking.poc.bankingdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class BankingDemoApplication {
    
    public static void main(String[] args) {
        run(BankingDemoApplication.class, args);
    }

}
