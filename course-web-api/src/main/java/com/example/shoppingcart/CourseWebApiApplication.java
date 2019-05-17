package com.example.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.coursewebapi.repository")
@SpringBootApplication
public class CourseWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseWebApiApplication.class, args);
	}

}
