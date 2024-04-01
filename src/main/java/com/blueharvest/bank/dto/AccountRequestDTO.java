package com.blueharvest.bank.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccountRequestDTO {
    private String customerId;
    private BigDecimal initialCredit;
    private String accountType;
}
