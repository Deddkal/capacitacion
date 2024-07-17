package com.mindhub.ToDoList.controllers;

import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userLogin){
        try{
            return userService.login(userLogin);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
