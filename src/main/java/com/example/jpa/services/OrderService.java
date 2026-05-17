package com.example.jpa.services;

import com.example.jpa.entities.Order;
import com.example.jpa.exeptions.DatabaseException;
import com.example.jpa.exeptions.ResourceNotFoundException;
import com.example.jpa.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
    public Order insert(Order obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não é possível deletar este pedido pois ele contém itens associados.");
        }
    }

    public Order update(Long id, Order obj) {
        try {
            Order entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order entity, Order obj) {
        entity.setMomment(obj.getMomment());
        entity.setOrderStatus(obj.getOrderStatus());
    }
}
