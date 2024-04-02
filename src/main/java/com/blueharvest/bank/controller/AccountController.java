package com.blueharvest.bank.controller;

import com.blueharvest.bank.dto.AccountDTO;
import com.blueharvest.bank.dto.AccountRequestDTO;
import com.blueharvest.bank.dto.UserInformationResponse;
import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@Api(value = "Account Management System", description = "Account management")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    @ApiOperation(value = "Open a new account")
    public AccountDTO  openAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.openAccount(accountRequestDTO);
    }

    @GetMapping("/{customerId}")
    @ApiOperation(value = "Get account information by customer ID")
    public UserInformationResponse getAccount(@PathVariable String customerId) {
        return accountService.getAccountByCustomerId(customerId);
    }
    @GetMapping
    @ApiOperation(value = "Get all accounts")
    public List<AccountDTO> getAllAccount() {
        return accountService.getAccountAllByCustomerId();
    }
}