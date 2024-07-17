package com.mindhub.ToDoList.controllers;

import com.mindhub.ToDoList.dtos.TaskDTOR;
import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.models.User;
import com.mindhub.ToDoList.repositories.TaskRepository;
import com.mindhub.ToDoList.repositories.UserRepository;
import com.mindhub.ToDoList.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.mindhub.ToDoList.utils.Mapper.taskMapper;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    //Servlet
    @GetMapping("/all")
    public ResponseEntity<Object> getAllTask(Authentication authentication){

        User user = userRepository.findByEmail(authentication.getName());

        List<TaskDTOR> tasks = taskRepository.findAll().stream().map(Mapper::taskMapper).collect(Collectors.toList());

        return ResponseEntity.ok(tasks);

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getTask(@PathVariable ){
//
//    }
//    @RequestMapping( method = RequestMethod.POST)
//    public ResponseEntity<String> createTask(){
//
//    }
}
