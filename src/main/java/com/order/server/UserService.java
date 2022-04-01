package com.order.server;

import com.order.entities.User;
import com.order.repositores.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @PersistenceContext
    protected EntityManager entityManager;

    public User get(Integer id) {
        return userRepo.findById(id).get();
    }

    public List<User> listAll() {
        return userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }
}
