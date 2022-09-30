package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);

    Product findById(int id);

    void update(int index,Product product);

    void remove(Product product);
    Product findByName(String name);
}
