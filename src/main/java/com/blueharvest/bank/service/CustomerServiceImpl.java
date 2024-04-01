package com.blueharvest.bank.service;

import com.blueharvest.bank.model.Customer;
import com.blueharvest.bank.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("123456", "Youssef", "surname1"));
        customers.add(new Customer("789012", "Jane", "surname2"));
        customers.add(new Customer("345678", "Alice", "surname3"));
        return customers;
    }

}