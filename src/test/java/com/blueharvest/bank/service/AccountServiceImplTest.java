package com.blueharvest.bank.service;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.dto.AccountRequestDTO;
import com.blueharvest.bank.dto.UserInformationResponse;
import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.model.Customer;
import com.blueharvest.bank.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
class AccountServiceImplTest {

    @Mock
    private TransactionService transactionService;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private AccountServiceImpl accountService ;

    private List<Account> accounts;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        accounts = new ArrayList<>();
    }

    @Test
    void testOpenAccount() {
        Transaction mockTransaction = new Transaction();
        mockTransaction.setTransactionId(UUID.randomUUID().toString());

        when(transactionService.addTransaction(anyString(), any(BigDecimal.class)))
                .thenReturn(mockTransaction);

        AccountRequestDTO requestDTO = AccountRequestDTO.builder().customerId("123456").initialCredit(BigDecimal.valueOf(1000))
                .accountType("Savings").build();

        AccountDTO accountDTO = accountService.openAccount(requestDTO);

        assertEquals(requestDTO.getAccountType(), accountDTO.getAccountType());
    }

    @Test
    void testGetAccountByCustomerId() {

        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId("123456");
        mockCustomer.setName("Youssef");
        mockCustomer.setSurname("Surname");

        when(customerService.getCustomers()).thenReturn(List.of(mockCustomer));

        Account mockAccount = new Account();
        mockAccount.setAccountId(UUID.randomUUID().toString());
        mockAccount.setCustomerId("123456");
        mockAccount.setBalance(BigDecimal.valueOf(1000));
        mockAccount.setAccountType("Savings");
        accounts.add(mockAccount);

        UserInformationResponse response = accountService.getAccountByCustomerId("123456");

        assertEquals(mockCustomer.getName(), response.getName());
        assertEquals(mockCustomer.getSurname(), response.getSurname());

    }


}