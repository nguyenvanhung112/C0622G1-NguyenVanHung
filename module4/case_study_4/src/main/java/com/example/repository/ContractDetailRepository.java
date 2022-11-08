package com.example.repository;

import com.example.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {


    @Query(value = "select * from contract_detail where contract_id = :id",nativeQuery = true)
    List<ContractDetail> findList(@Param("id") int id);
}
