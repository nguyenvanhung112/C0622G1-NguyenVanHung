package com.example.repository;

import com.example.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {


    @Query(value = "select * from contract where delete_status = 1",nativeQuery = true)
    Page<Contract> getList(Pageable pageable);
}
