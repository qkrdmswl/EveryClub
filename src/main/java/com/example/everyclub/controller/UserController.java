package com.example.everyclub.controller;

import com.example.everyclub.controller.dto.UserDetailDto;
import com.example.everyclub.controller.dto.UserLoginDto;
import com.example.everyclub.controller.dto.UserSaveDto;
import com.example.everyclub.service.UserService;
import com.example.everyclub.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor  // 생성자(private final UserService userService) 주입을 위해 사용
public class UserController {

    private final UserServiceImpl userServiceImpl;

    // 회원가입 페이지 요청
    @GetMapping("save")
    public String saveForm() {
        return "user/save";
    }

    // 회원가입 정보 저장
    @PostMapping("save")
    public String save(@ModelAttribute UserSaveDto userSaveDTO) {
        Long userId = userServiceImpl.save(userSaveDTO);
        return "user/login";
    }

    @GetMapping("login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute UserLoginDto userLoginDto, HttpSession session) {
        if(userServiceImpl.login(userLoginDto)) {
            session.setAttribute("loginEmail", userLoginDto.getUserEmail());
            return "redirect:/user/";
        } else {
            return "user/login";
        }
    }

    @GetMapping
    public String findAll(Model model) {
        List<UserDetailDto> userList = userServiceImpl.findAll();
        model.addAttribute("userList", userList);
        return "user/findAll";
    }

    @GetMapping("{userId}")
    public String findById(@PathVariable Long userId, Model model) { // 받는 값의 이름과 매개변수 값 이름이 같다면 생략가능
        UserDetailDto userDetailDto = userServiceImpl.findById(userId);
        model.addAttribute("user", userDetailDto);
        return "user/findById";
    }

    @GetMapping("delete/{userId}")
    public String deleteById(@PathVariable Long userId) {
        userServiceImpl.deleteById(userId);
        return "redirect:/user/";
    }
}
