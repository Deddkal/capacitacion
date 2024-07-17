package com.mindhub.ToDoList.services.impl;

import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.repositories.TaskRepository;
import com.mindhub.ToDoList.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findById(UUID id) {
        return null;
    }

    @Override
    public void save(Task entity) {

    }

    @Override
    public void delete(Task entity) {

    }

    @Override
    public List<Task> findAll() {
        return null;
    }
}
