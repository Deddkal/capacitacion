package com.mindhub.ToDoList.services.impl;

import com.mindhub.ToDoList.configSegurity.ClientDetailsService;
import com.mindhub.ToDoList.configSegurity.jwt.JwtUtils;
import com.mindhub.ToDoList.dtos.UserDTO;
import com.mindhub.ToDoList.models.User;
import com.mindhub.ToDoList.repositories.UserRepository;
import com.mindhub.ToDoList.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements IUserService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<String> login(UserDTO userLogin) {
        try{
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userLogin.email(), userLogin.password(), Collections.emptyList());
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if(authentication.isAuthenticated()){
                String jwt = jwtUtils.generateToken(clientDetailsService.getUserDetail().getEmail(), "CLIENT");
                return ResponseEntity.ok("{\"token\":\""+jwt+"\"}");
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return new ResponseEntity<String>("{\"message\":\""+"Bad Credentials"+"\"}", HttpStatus.BAD_REQUEST);
    }
}
