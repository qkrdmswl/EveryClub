package com.example.everyclub.controller.member;

import com.example.everyclub.controller.member.dto.MemberDetailDTO;
import com.example.everyclub.controller.member.dto.MemberLoginDTO;
import com.example.everyclub.controller.member.dto.MemberSaveDTO;
import com.example.everyclub.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
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

    @GetMapping("login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute MemberLoginDTO memberLoginDTO, HttpSession session) {
        if(memberService.login(memberLoginDTO)) {
            session.setAttribute("loginEmail", memberLoginDTO.getMemberEmail());
            return "redirect:/member/";
        } else {
            return "member/login";
        }
    }

    @GetMapping
    public String findAll(Model model) {
        List<MemberDetailDTO> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "member/findAll";
    }

    @GetMapping("{memberId}")
    public String findById(@PathVariable Long memberId, Model model) { // 받는 값의 이름과 매개변수 값 이름이 같다면 생략가능
        MemberDetailDTO memberDetailDTO = memberService.findById(memberId);
        model.addAttribute("member", memberDetailDTO);
        return "member/findById";
    }

    @GetMapping("delete/{memberId}")
    public String deleteById(@PathVariable Long memberId) {
        memberService.deleteById(memberId);
        return "redirect:/member/";
    }
}
