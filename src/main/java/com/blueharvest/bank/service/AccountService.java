package com.blueharvest.bank.service;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.dto.AccountRequestDTO;
import com.blueharvest.bank.dto.UserInformationResponse;
import com.blueharvest.bank.model.Account;

import java.util.List;

public interface AccountService {
    AccountDTO  openAccount(AccountRequestDTO accountRequestDTO);
    UserInformationResponse getAccountByCustomerId(String customerId);
    List<AccountDTO> getAccountAllByCustomerId();
}
