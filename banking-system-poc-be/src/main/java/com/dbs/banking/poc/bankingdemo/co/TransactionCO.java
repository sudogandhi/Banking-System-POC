package com.dbs.banking.poc.bankingdemo.co;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionCO {

    @NotNull
    LocalDateTime fromDate;

    @NotNull
    LocalDateTime toDate;

    @NotNull
    Long accountNo;

}
