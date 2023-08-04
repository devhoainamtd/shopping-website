package dev.hoainamtd;

import dev.hoainamtd.model.Role;
import dev.hoainamtd.model.UserEntity;
import dev.hoainamtd.repository.RoleRepository;
import dev.hoainamtd.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ProductManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagerApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(UserServiceImpl userService, RoleRepository roleRepository) {
//		return args -> {
//
//			userService.saveRole(new Role("USER"));
//			userService.saveRole(new Role("ADMIN"));
//			userService.saveRole(new Role("EDITOR"));
//
//			userService.saveUser(new UserEntity("hoai nam", "truong dinh", "namtd", passwordEncoder().encode("password"), new ArrayList<>()));
//			userService.saveUser(new UserEntity("thanh", "nguyen danh", "thanh", passwordEncoder().encode("password"), new ArrayList<>()));
//			userService.saveUser(new UserEntity("hung", "tran", "hung", passwordEncoder().encode("password"), new ArrayList<>()));
//
//
//			userService.addToUser("namtd", "USER");
//			userService.addToUser("thanh", "ADMIN");
//			userService.addToUser("hung", "EDITOR");
//		};
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}
