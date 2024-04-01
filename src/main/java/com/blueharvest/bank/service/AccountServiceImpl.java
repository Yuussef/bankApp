package com.blueharvest.bank.service;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.dto.AccountRequestDTO;
import com.blueharvest.bank.dto.UserInformationResponse;
import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.model.Customer;
import com.blueharvest.bank.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.blueharvest.bank.dto.AccountDTO.fromAccountDTO;
import static com.blueharvest.bank.dto.AccountDTO.fromAccountDTOList;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final List<Account> accounts = new ArrayList<>();
    private final TransactionService transactionService;
    private final CustomerService customerService;



    @Override
    public AccountDTO openAccount(AccountRequestDTO accountRequestDTO) {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setCustomerId(accountRequestDTO.getCustomerId());
        account.setBalance(accountRequestDTO.getInitialCredit());
        account.setAccountType(accountRequestDTO.getAccountType());
        accounts.add(account);
        if (accountRequestDTO.getInitialCredit().compareTo(BigDecimal.ZERO) != 0) {
            List<Transaction> transactions=new ArrayList<>();
            transactions.add(transactionService.addTransaction(account.getAccountId(), accountRequestDTO.getInitialCredit()));
            account.setTransactionList(transactions);
        }
        return fromAccountDTO(account);
    }

    @Override
    public UserInformationResponse getAccountByCustomerId(String customerId) {
        Optional<Customer> filteredCustomer = customerService.getCustomers().stream()
                .filter(customer -> customer.getCustomerId().equals(customerId)).findFirst();
        List<Account> filteredAccounts = accounts.stream()
                .filter(account -> account.getCustomerId().equals(customerId))
                .collect(Collectors.toList());

        return UserInformationResponse.builder().name(filteredCustomer.get().getName()).surname(filteredCustomer.get().getSurname())
                .accountDTOS(fromAccountDTOList(filteredAccounts)).build();
    }

    @Override
    public List<AccountDTO> getAccountAllByCustomerId() {
        return fromAccountDTOList(accounts);
    }


}