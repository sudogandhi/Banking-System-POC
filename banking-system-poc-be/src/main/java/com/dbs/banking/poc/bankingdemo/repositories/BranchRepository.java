package com.dbs.banking.poc.bankingdemo.repositories;

import com.dbs.banking.poc.bankingdemo.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    Branch findByIfscCode(String ifscCode);

    @Query("SELECT b.branchName from Branch b")
    List<String> getBranchNames();

    @Override
    List<Branch> findAll();
}
