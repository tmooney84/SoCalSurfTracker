package dev.group.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);}

//	@Bean
//	CommandLineRunner commandLineRunner(UserService userService, BCryptPasswordEncoder encoder){
//		return args -> {
//
//			userService.save(new User("user", encoder.encode("password")));
//		};
//	}

}
