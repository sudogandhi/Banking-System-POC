package com.dbs.banking.poc.bankingdemo.entities;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transaction")
public class Transaction extends BaseEntity {

    @Column(name = "senderId")
    @NotNull
    private Long senderId;

    @Column(name = "receiverId")
    @NotNull
    private Long receiverId;

    @Column(name = "amountTransferred")
    @NotNull
    private double amountTransferred;

    @Column(name = "senderOldBalance")
    @NotNull
    private double senderOldBalance;

    @Column(name = "senderNewBalance")
    @NotNull
    private double senderNewBalance;

    @Column(name = "receiverOldBalance")
    @NotNull
    private double receiverOldBalance;

    @Column(name = "receiverNewBalance")
    @NotNull
    private double receiverNewBalance;

    @Column(name = "isFailed")
    @NotNull
    private boolean isFailed;

    @Column(name = "isChecked")
    @NotNull
    private boolean isChecked;

}
