package com.order.dao;

import com.order.entities.Product;

import java.util.List;

public interface ProductDao {
    public Product findById(int id);
    public List<Product> findProductByCategory(int id);
    public Boolean create(Product product);
}
