package com.example.service.impl;

import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.repository.CustomerRepository;
import com.example.repository.CustomerTypeRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Page<Customer> search(String nameSearch, String customerType, String email, Pageable pageable) {
        return customerRepository.findByNameAndEmailAndCustomerType(nameSearch, customerType, email, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerByID(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }


}
