package com.example.everyclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableJpaAuditing
public class EveryclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveryclubApplication.class, args);
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

}

