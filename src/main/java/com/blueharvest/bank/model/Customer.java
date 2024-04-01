package com.blueharvest.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String customerId;
    private String name;
    private String surname;

    public Customer() {

    }
}