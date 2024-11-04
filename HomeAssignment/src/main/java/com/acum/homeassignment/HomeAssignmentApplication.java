package com.acum.homeassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HomeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeAssignmentApplication.class, args);
	}

}
