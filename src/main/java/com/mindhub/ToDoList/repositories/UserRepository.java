package com.mindhub.ToDoList.repositories;

import com.mindhub.ToDoList.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmail(String email);
}
