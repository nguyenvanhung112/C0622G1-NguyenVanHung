package com.example.service;

import com.example.model.Customer;
import com.example.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerType> findAllCustomerType();

    Page<Customer> search(String nameSearch, String email, String customerType, Pageable pageable);

    void save(Customer customer);
}
