package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Account;
import org.springframework.data.repository.Repository;

public interface AccountRepository extends Repository<Account,Long> {
}
