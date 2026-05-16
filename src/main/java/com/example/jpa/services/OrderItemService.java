package com.example.jpa.services;

import com.example.jpa.entities.OrderItem;
import com.example.jpa.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> findAll(){
        return repository.findAll();
    }

    public OrderItem findById(long id){
        Optional<OrderItem> obj = repository.findById(id);
        return obj.get();
    }

}
