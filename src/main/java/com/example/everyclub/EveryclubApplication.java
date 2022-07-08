package com.example.everyclub;

import com.example.everyclub.DTO.MemberSaveDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class EveryclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveryclubApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

}

