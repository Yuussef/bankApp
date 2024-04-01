package com.blueharvest.bank.dto;

import com.blueharvest.bank.model.Account;
import com.blueharvest.bank.model.Transaction;
import com.blueharvest.bank.service.TransactionService;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class TransactionDTO {
    private String transactionId;
    private String accountId;
    private BigDecimal amount;

    public static TransactionDTO fromTransactionDTO(Transaction transaction) {
        return TransactionDTO.builder().transactionId(transaction.getTransactionId())
                .accountId(transaction.getAccountId()).amount(transaction.getAmount())
                .build();
    }
    public static List<TransactionDTO> fromTransactionDTOList(List<Transaction> transaction) {
        if(transaction!=null) {
            return transaction.stream().map(TransactionDTO::fromTransactionDTO).collect(Collectors.toList());
        }
        return null;
    }
}
