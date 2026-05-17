package com.example.jpa.exeptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID =1L;

    public ResourceNotFoundException(Object id) {
        super ("Recurso não encontrado.  ID: " +id);
    }
}
