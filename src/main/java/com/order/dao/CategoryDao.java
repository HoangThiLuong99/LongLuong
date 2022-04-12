package com.order.dao;

import com.order.entities.Category;

import java.util.List;

public interface CategoryDao {
    public Category findById(int id);
    public Category findByName(String name);
    public Boolean create(Category category);
}
