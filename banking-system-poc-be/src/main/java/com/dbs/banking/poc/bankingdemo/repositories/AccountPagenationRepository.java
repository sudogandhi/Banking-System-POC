package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Account;
import com.dbs.banking.poc.bankingdemo.entities.Customer;
import com.dbs.banking.poc.bankingdemo.entities.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountPagenationRepository extends JpaRepository<Account,Long> {
    Page<Account> findByIsActivated(Boolean activated, Pageable pageable);

    Page<Account> findByIsBlocked(Boolean blocked,Pageable pageable);

    Page<Account> findAll(Pageable pageable);

}
