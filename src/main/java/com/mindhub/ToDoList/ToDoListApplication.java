package com.mindhub.ToDoList;

import com.mindhub.ToDoList.models.Task;
import com.mindhub.ToDoList.models.User;
import com.mindhub.ToDoList.repositories.TaskRepository;
import com.mindhub.ToDoList.repositories.UserRepository;
import com.mindhub.ToDoList.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, TaskRepository taskRepository){
		return args -> {
			User user = new User("Pepito", "pepito@mindhub.com", passwordEncoder.encode("123456"));

			Task task1 = new Task("Figma");
			userRepository.save(user);

			user.addTask(task1);

			taskRepository.save(task1);
		};
	}
}
