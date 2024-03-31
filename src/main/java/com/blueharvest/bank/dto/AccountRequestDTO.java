package com.blueharvest.bank.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRequestDTO {
    private String customerId;
    private double initialCredit;
    private String accountType;
}
