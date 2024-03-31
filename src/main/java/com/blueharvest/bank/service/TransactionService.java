package com.blueharvest.bank.service;

public interface TransactionService {
    void makeTransaction(String accountId, double amount);
}
