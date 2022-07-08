package com.example.everyclub;

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

	// 회원가입 페이지 요청
	@GetMapping("save")
	public String saveForm() {
		return "member/save";
	}

//	// 회원가입 정보 저장
//	@PostMapping("save")
//	public String save(@ModelAttribute MemberSaveDTO memberSaveDTO) {
//		Long memberId = ms.save(memberSaveDTO);
//		return "member/login";
//	}

}

