package com.blueharvest.bank.service;

import com.blueharvest.bank.model.Transaction;

import java.math.BigDecimal;

public interface TransactionService {
    Transaction addTransaction(String accountId, BigDecimal amount);
}
