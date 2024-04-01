package com.blueharvest.bank.controller;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.dto.AccountRequestDTO;
import com.blueharvest.bank.dto.UserInformationResponse;
import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("")
    public AccountDTO  openAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.openAccount(accountRequestDTO);
    }

    @GetMapping("/{customerId}")
    public UserInformationResponse getAccount(@PathVariable String customerId) {
        return accountService.getAccountByCustomerId(customerId);
    }
    @GetMapping("")
    public List<AccountDTO> getAllAccount() {
        return accountService.getAccountAllByCustomerId();
    }
}