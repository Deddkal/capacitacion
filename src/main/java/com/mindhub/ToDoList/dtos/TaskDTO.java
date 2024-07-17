package com.mindhub.ToDoList.dtos;

import com.mindhub.ToDoList.models.Task;

import java.util.UUID;

public class TaskDTO {

    private final UUID id;

    public TaskDTO(Task task) {
        this.id = task.getId();
    }
}
