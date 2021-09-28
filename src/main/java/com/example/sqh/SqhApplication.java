package com.example.sqh;

import com.example.sqh.entity.User;
import com.example.sqh.enums.Status;
import com.example.sqh.enums.UsetType;
import com.example.sqh.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class SqhApplication {

	public static void main(String[] args) {

//		ConfigurableApplicationContext configurableApplicationContext =
						SpringApplication.run(SqhApplication.class, args);
//		UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
//		String name = "admin";
//		String pass = "1234";
//		User user = new User();
//		user.setName(name.toUpperCase());
//		user.setPassword(pass);
//		user.setUserType(UsetType.ADMIN);
//		user.setStatus(Status.ACTIVE);
	}

	@Bean
	public CommandLineRunner demoData(UserRepository repo) {
		return args -> {
			String name = "admin";
			String pass = "1234";
			User user = new User();
			user.setName(name.toUpperCase());
			user.setPassword(pass);
			user.setUserType(UsetType.ADMIN);
			user.setStatus(Status.ACTIVE);
			repo.save(user);
		};
	}
}
