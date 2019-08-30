package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Customer;
import org.springframework.data.repository.Repository;

public interface CustomerRepository extends Repository<Customer, Long> {
}
