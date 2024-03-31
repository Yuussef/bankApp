package com.blueharvest.bank.service.impl;

import com.blueharvest.bank.model.Transaction;
import com.blueharvest.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final Map<String, Transaction> transactions = new HashMap<>();

    @Override
    public void makeTransaction(String accountId, double amount) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transactions.put(transaction.getTransactionId(), transaction);
    }
}