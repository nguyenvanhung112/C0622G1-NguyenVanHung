package com.example.orderbook.repository;

import com.example.orderbook.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderBook,Integer> {
    @Query(value = "select * from order_book where code = :keyword",nativeQuery = true)
    OrderBook findCode(@Param("keyword") String code);
}
