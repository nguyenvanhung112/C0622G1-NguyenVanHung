package com.example.orderbook.repository;

import com.example.orderbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
