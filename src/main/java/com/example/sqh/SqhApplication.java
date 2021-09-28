package com.example.sqh;

import com.example.sqh.entity.User;
import com.example.sqh.enums.Status;
import com.example.sqh.enums.UsetType;
import com.example.sqh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Locale;

@SpringBootApplication
public class SqhApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SqhApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(UserRepository repo) {
		return args -> {
			String name = "admin";
			String pass = "1234";
			User user = new User();
			user.setName(name.toUpperCase());
			user.setPassword(passwordEncoder.encode(pass));
			user.setUserType(UsetType.ADMIN);
			user.setStatus(Status.ACTIVE);
			repo.save(user);
		};
	}
}
