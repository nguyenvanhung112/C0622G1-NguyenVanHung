package com.example.service;

import com.example.model.Employee.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

    List<Employee> getListEmployee();
}
