package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Account;
import com.dbs.banking.poc.bankingdemo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Query("SELECT t from Transaction t where t.sender = ?1 or t.receiver = ?1 order by createdAt DESC")
    List<Transaction> userTransactions(Account account);

//    @Query("SELECT t from Transaction t where t.createdAt between '2019-08-12 21:48:14.654000' and '2019-10-12 21:48:14.654000'")
//    List<Transaction> transactionBetweenDates(LocalDateTime fromDate, LocalDateTime toDate);

}
