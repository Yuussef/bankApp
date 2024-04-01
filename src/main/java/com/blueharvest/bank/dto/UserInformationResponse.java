package com.blueharvest.bank.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class UserInformationResponse {
    private String name;
    private String surname;
    private BigDecimal balance;
    private List<AccountDTO> accountDTOS;
}
