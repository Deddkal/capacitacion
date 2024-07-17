package com.mindhub.ToDoList.services;

import java.util.List;
import java.util.UUID;

public interface IGenericService<E> {

    E findById(UUID id);

    void save(E entity);

    void delete(E entity);

    List<E> findAll();

}
