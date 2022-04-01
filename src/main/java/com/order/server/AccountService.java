package com.order.server;

import com.order.entities.Account;
import com.order.entities.User;
import com.order.repositores.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    public void create(Account account) {
        accountRepo.save(account);
    }

    public Account get(Integer id) {
        return accountRepo.findById(id).get();
    }

    public void delete(Integer id) {
        accountRepo.deleteById(id);
    }
}
