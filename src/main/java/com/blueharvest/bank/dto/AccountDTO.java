package com.blueharvest.bank.dto;

import com.blueharvest.bank.model.Account;
import io.micrometer.common.util.StringUtils;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.blueharvest.bank.dto.TransactionDTO.fromTransactionDTO;
import static com.blueharvest.bank.dto.TransactionDTO.fromTransactionDTOList;

@Data
@Builder
public class AccountDTO {
    private String accountId;
    private String customerId;
    private BigDecimal balance;
    private String accountType;
    private  List<TransactionDTO> transactions;

    public static AccountDTO fromAccountDTO(Account account) {
        return AccountDTO.builder().accountId(account.getAccountId())
                .customerId(account.getCustomerId()).balance(account.getBalance())
                .accountType(account.getAccountType())
                .transactions(fromTransactionDTOList(account.getTransactionList()))
                .build();
    }
    public static List<AccountDTO> fromAccountDTOList(List<Account> accounts) {
        return accounts.stream().map(AccountDTO::fromAccountDTO).collect(Collectors.toList());
    }

}