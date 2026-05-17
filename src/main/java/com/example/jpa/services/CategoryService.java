package com.example.jpa.services;

import com.example.jpa.entities.Category;
import com.example.jpa.exeptions.ResourceNotFoundException;
import com.example.jpa.repository.CategoryRespository;

import jakarta.persistence.EntityNotFoundException;
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

    public Category insert(Category obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.findById(id);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public Category update(Long id, Category obj){
        try {
            Category entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Category entity, Category obj) {
        entity.setName(obj.getName());
    }


}
