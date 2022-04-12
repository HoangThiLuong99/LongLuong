package com.order.server;

import com.order.entities.Category;
import com.order.repositores.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

//    public Response findAll()  {
//        Response rs = new Response();
//        rs.setStatus(1);
//        rs.setMessage("OK");
//        rs.setCode(200);
//
//        List<Category> lst = categoryRepo.findAll();
//
//        rs.setData(lst);
//        return rs;
//    }



}
