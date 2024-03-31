package com.blueharvest.bank.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private String accountId;
    private String customerId;
    private double balance;
}