package ru.geekbrains.product;

import java.util.List;
public interface ProductRepository {
    List<Product> findAll();
    Product findById(long id);
    void insert(Product product);
    void delete(long id);
}
