package dev.johnson.proj0redo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.johnson")
@EntityScan(basePackages = "dev.johnson.entities")
@EnableJpaRepositories(basePackages = "dev.johnson.repos")

public class Proj0redoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj0redoApplication.class, args);
	}

}
