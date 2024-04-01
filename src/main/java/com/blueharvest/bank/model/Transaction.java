package com.blueharvest.bank.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {
    private String transactionId;
    private String accountId;
    private BigDecimal amount;
}
