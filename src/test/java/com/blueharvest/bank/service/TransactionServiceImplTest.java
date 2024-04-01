package com.blueharvest.bank.service;

import com.blueharvest.bank.model.Transaction;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionServiceImplTest {

    @Test
    void testAddTransaction() {

        TransactionService transactionService = new TransactionServiceImpl();

        String accountId = UUID.randomUUID().toString();
        BigDecimal amount = BigDecimal.valueOf(1000);

        Transaction transaction = transactionService.addTransaction(accountId, amount);

        assertNotNull(transaction);

        assertEquals(accountId, transaction.getAccountId());
        assertEquals(amount, transaction.getAmount());
        assertNotNull(transaction.getTransactionId());
    }
}
