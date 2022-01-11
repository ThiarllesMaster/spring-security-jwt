package com.javatechie.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct	
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "user1", "$2a$10$r69UlRbbm93Kc8J8WD.2wOoI2NZw/PPztKz1DdTrtrU917zzWuPyW", "ROLE_ADMIN"),
				new User(102, "user2", "$2a$10$Jt5mXIhuPT/771hA4eSwxepe4Vt0BrIl3YPYTje9H2N.Mlks4jj0G", "ROLE_ADMIN"), 
				new User(103, "user3", "pwd3", "user3@gmail.com"), 
				new User(104, "user4", "pwd4", "user4@gmail.com")
				).collect(Collectors.toList());
		
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
