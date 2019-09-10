package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Account;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findAllByCustomer(Customer customer);

    @Query("SELECT a.id from Account a")
    List<Long> getAllAccountsNumber();

    @Query("SELECT a.id from Account a where a.customer = ?1")
    List<Long> getAccountsNumber(Customer customer);
}
