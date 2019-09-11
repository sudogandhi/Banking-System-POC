package com.dbs.banking.poc.bankingdemo.co;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SendMoneyCO {

    Long sender;
    Long receiver;
    Double amount;
}
