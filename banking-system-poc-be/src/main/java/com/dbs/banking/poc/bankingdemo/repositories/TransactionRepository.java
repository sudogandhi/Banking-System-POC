package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Transaction;
import org.springframework.data.repository.Repository;

public interface TransactionRepository extends Repository<Transaction,Integer> {
}
