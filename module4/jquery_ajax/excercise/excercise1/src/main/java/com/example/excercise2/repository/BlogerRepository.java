package com.example.excercise2.repository;


import com.example.excercise2.model.Bloger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogerRepository extends JpaRepository<Bloger,Integer> {

    Page<Bloger> findAllByNameContainingOrderByDateDesc(String blogName, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM Bloger  where category_id = :keyword", nativeQuery = true)
    List<Bloger> findByCategory(@Param("keyword") int categoryId);


    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM Bloger  where name like %:keyword%", nativeQuery = true)
    List<Bloger> search(@Param ("keyword") String search);
}
