package com.example.orderbook.service.impl;

import com.example.orderbook.model.OrderBook;
import com.example.orderbook.repository.OrderRepository;
import com.example.orderbook.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderBook> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(OrderBook orderBook) {
        orderRepository.save(orderBook);
    }

    @Override
    public OrderBook findById(int id) {
        return orderRepository.findById(id).orElse(new OrderBook());
    }

    @Override
    public OrderBook findCode(String code) {
        return orderRepository.findCode(code);
    }

    @Override
    public void remove(OrderBook orderBook) {
        orderRepository.delete(orderBook);
    }
}
