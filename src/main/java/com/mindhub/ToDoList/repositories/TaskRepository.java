package com.mindhub.ToDoList.repositories;

import com.mindhub.ToDoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
