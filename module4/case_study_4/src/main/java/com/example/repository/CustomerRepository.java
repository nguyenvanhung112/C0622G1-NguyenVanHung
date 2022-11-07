package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {




    @Query(value = "select c.* from `customer` c inner join `customer_type` ct " +
            "on c.customer_type_id = ct.id " +
            "where c.name like %:name% and c.email like %:email% and ct.name like %:type% and c.delete_status= 1", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerType(@Param("name") String nameSearch,
                                                     @Param("email") String email,
                                                     @Param("type") String customerType,
                                                     Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update customer set delete_status = 0 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);
}
