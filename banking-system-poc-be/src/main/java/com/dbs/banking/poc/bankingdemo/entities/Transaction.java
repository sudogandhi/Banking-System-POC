package com.dbs.banking.poc.bankingdemo.entities;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction extends BaseEntity {

//    @Column(name = "senderId")
//    @NotNull
//    private Long senderId;
//
//    @Column(name = "receiverId")
//    @NotNull
//    private Long receiverId;

    @ManyToOne
    private Account sender;

    @ManyToOne
    private Account receiver;

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
