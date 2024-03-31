package com.blueharvest.bank.service.impl;

import com.blueharvest.bank.model.Customer;
import com.blueharvest.bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final Map<String, Customer> customers = new HashMap<>();

    @Override
    public Customer getCustomerById(String customerId) {
        return customers.get(customerId);
    }
}