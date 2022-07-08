package com.example.everyclub.controller;

import com.example.everyclub.DTO.MemberSaveDTO;
import com.example.everyclub.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor  // 생성자(private final MemberService memberService) 주입을 위해 사용
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지 요청
    @GetMapping("save")
    public String saveForm() {
        return "member/save";
    }

    // 회원가입 정보 저장
    @PostMapping("save")
    public String save(@ModelAttribute MemberSaveDTO memberSaveDTO) {
        Long memberId = memberService.save(memberSaveDTO);
        return "member/login";
    }
}
