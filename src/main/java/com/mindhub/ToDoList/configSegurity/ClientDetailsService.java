package com.mindhub.ToDoList.configSegurity;

import com.mindhub.ToDoList.models.User;
import com.mindhub.ToDoList.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class ClientDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private User user;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user = userRepository.findByEmail(username);
        if(!Objects.isNull(user)){
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public User getUserDetail(){
        return user;
    }
}
