package com.blueharvest.bank.service;

import com.blueharvest.bank.model.Customer;

public interface CustomerService {
    Customer getCustomerById(String customerId);
}