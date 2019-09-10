package com.dbs.banking.poc.bankingdemo.co;

import com.dbs.banking.poc.bankingdemo.entities.AccountType;
import com.dbs.banking.poc.bankingdemo.entities.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCO {

    @NotNull
    String accountType;

    @NotNull
    Long branchId;
}
