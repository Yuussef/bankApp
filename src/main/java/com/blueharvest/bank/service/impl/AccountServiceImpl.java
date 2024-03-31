package com.blueharvest.bank.service.impl;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.service.AccountService;
import com.blueharvest.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final Map<String, Account> accounts = new HashMap<>();
    private final TransactionService transactionService;

    @Override
    public AccountDTO  openAccount(String customerId, double initialCredit) {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setCustomerId(customerId);
        account.setBalance(initialCredit);
        accounts.put(account.getAccountId(), account);
        if (initialCredit != 0) {
            transactionService.makeTransaction(account.getAccountId(), initialCredit);
        }
        return AccountDTO.builder().accountId(account.getAccountId())
                .customerId(account.getCustomerId()).balance(account.getBalance())
                .build();
        /*s*/
    }

    @Override
    public AccountDTO  getAccountByCustomerId(String customerId) {
        for (Account account : accounts.values()) {
            if (account.getCustomerId().equals(customerId)) {
                return AccountDTO.builder().accountId(account.getAccountId())
                        .customerId(account.getCustomerId()).balance(account.getBalance())
                        .build();
            }
        }

        return null;
    }


}