package com.order.server;

import com.order.repositores.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @PersistenceContext
    protected EntityManager entityManager;

    public void delete(Integer id) {
        productRepo.deleteById(id);
    }
}
