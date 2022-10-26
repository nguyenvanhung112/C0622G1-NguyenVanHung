package com.example.orderbook.service;

import com.example.orderbook.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(int id);
}
