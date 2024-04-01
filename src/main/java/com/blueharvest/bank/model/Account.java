package com.blueharvest.bank.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Account {
    private String accountId;
    private String customerId;
    private BigDecimal balance;
    private String accountType;
    private List<Transaction> transactionList;
}