package com.mindhub.ToDoList.utils;

import com.mindhub.ToDoList.dtos.TaskDTOR;
import com.mindhub.ToDoList.models.Task;

public class Mapper {

    public static TaskDTOR taskMapper(Task task){

        return new TaskDTOR(task.getId(),task.getName(),task.getDone());
    }

}
