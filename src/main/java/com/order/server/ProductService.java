package com.order.server;

import com.order.dao.ProductDao;
import com.order.entities.Product;
import com.order.repositores.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

//    @PersistenceContext
//    protected EntityManager entityManager;

//    public List<Product> findByCategory(int id) {
//        List<Product> lst = productDao.findProductByCategory(id);
//        List<Product> ls = new ArrayList<>();
//        for (Product s : lst){
//            int productId = s.getProductId();
//        }
//    }
}
