package com.example.orderbook.service;

import com.example.orderbook.model.OrderBook;

import java.util.List;

public interface IOrderService {
    List<OrderBook> findAll();

    void save(OrderBook orderBook);

    OrderBook findById(int id);

    OrderBook findCode(String code);

    void remove(OrderBook orderBook);
}
