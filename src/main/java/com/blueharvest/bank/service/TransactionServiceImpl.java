package com.blueharvest.bank.service;

import com.blueharvest.bank.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Transaction addTransaction(String accountId, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
       return  transaction;
    }
}