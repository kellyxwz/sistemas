package com.example.jpa.services;

import com.example.jpa.entities.Category;
import com.example.jpa.entities.OrderItem;
import com.example.jpa.repository.CategoryRespository;
import com.example.jpa.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
