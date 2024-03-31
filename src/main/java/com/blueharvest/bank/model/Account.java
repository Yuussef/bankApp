package com.blueharvest.bank.model;

import lombok.Data;

@Data
public class Account {
    private String accountId;
    private String customerId;
    private double balance;
    private String accountType;
}