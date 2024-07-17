package com.mindhub.ToDoList.services;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.models.User;
import org.springframework.http.ResponseEntity;

public interface IUserService extends IGenericService<User>{

    ResponseEntity<String> login(UserDTO userLogin);

}
