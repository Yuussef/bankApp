package com.blueharvest.bank.model;

import lombok.Data;

@Data
public class Transaction {
    private String transactionId;
    private String accountId;
    private double amount;
}
