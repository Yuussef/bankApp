package com.blueharvest.bank.dto;

import com.blueharvest.bank.model.Account;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class AccountDTO {
    private String accountId;
    private String customerId;
    private double balance;
    private String accountType;

    public static AccountDTO fromAccountDTO(Account account) {
        return AccountDTO.builder().accountId(account.getAccountId())
                .customerId(account.getCustomerId()).balance(account.getBalance())
                .accountType(account.getAccountType())
                .build();
    }
    public static List<AccountDTO> fromAccountDTOList(List<Account> accounts) {
        return accounts.stream().map(AccountDTO::fromAccountDTO).collect(Collectors.toList());
    }

}