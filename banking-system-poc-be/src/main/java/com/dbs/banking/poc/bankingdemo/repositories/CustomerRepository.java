package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
