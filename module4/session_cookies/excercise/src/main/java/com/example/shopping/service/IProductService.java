package com.example.shopping.service;

import com.example.shopping.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);

    List<Product> findAll();
}
