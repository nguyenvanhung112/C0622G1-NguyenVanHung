package com.example.practice.repository;


import com.example.practice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from Customer where id =:id", nativeQuery = true)
    Customer findId(@Param("id") int id);
}
