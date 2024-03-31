package com.blueharvest.bank.service;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.model.Account;

public interface AccountService {
    AccountDTO  openAccount(String customerId, double initialCredit);
    AccountDTO getAccountByCustomerId(String customerId);
}
