package com.me.moviecache;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.boot.SpringApplication.run;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		run(Application.class, args);
	}
}