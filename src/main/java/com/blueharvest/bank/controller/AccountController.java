package com.blueharvest.bank.controller;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/open")
    public AccountDTO  openAccount(@RequestParam String customerId, @RequestParam double initialCredit) {
        return accountService.openAccount(customerId, initialCredit);
    }

    @GetMapping("/{customerId}")
    public AccountDTO getAccount(@PathVariable String customerId) {
        return accountService.getAccountByCustomerId(customerId);
    }
}