package com.example.practice.service;


import com.example.practice.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService  {

    void save(Customer customer);

    List<Customer> findAll();

    Customer findById(int id);

    void remove(Customer customer);
}

