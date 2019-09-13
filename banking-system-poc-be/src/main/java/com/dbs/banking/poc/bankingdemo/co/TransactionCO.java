package com.dbs.banking.poc.bankingdemo.co;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionCO {

    @NotNull
    String fromDate;

    @NotNull
    String toDate;

    @NotNull
    Long accountNo;

}
