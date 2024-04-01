package com.blueharvest.bank.service.impl;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.dto.AccountRequestDTO;
import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.model.Transaction;
import com.blueharvest.bank.service.AccountService;
import com.blueharvest.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.blueharvest.bank.dto.AccountDTO.fromAccountDTO;
import static com.blueharvest.bank.dto.AccountDTO.fromAccountDTOList;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final List<Account> accounts = new ArrayList<>();
    private final TransactionService transactionService;

    @Override
    public AccountDTO openAccount(AccountRequestDTO accountRequestDTO) {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setCustomerId(accountRequestDTO.getCustomerId());
        account.setBalance(accountRequestDTO.getInitialCredit());
        account.setAccountType(accountRequestDTO.getAccountType());
        accounts.add(account); // Add the account to the list
        if (accountRequestDTO.getInitialCredit().compareTo(BigDecimal.ZERO) != 0) {
            List<Transaction> transactions=new ArrayList<>();
            transactions.add(transactionService.addTransaction(account.getAccountId(), accountRequestDTO.getInitialCredit()));
            account.setTransactionList(transactions);
        }
        return fromAccountDTO(account);
    }

    @Override
    public AccountDTO  getAccountByCustomerId(String customerId) {
        Optional<Account> optionalAccount = accounts.stream()
                .filter(account -> account.getCustomerId().equals(customerId))
                .findFirst();

        return optionalAccount.map(AccountDTO::fromAccountDTO
        ).orElse(null);
    }

    @Override
    public List<AccountDTO> getAccountAllByCustomerId() {
        return fromAccountDTOList(accounts);
    }


}