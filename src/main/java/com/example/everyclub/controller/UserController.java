package com.example.everyclub.controller;

import com.example.everyclub.controller.dto.UserDetailDto;
import com.example.everyclub.controller.dto.UserDto;
import com.example.everyclub.service.user.AuthUserService;
import com.example.everyclub.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final AuthUserService userService;

    // 회원가입 페이지 요청
    @GetMapping("save")
    public String saveForm() {
        return "user/save";
    }

    // 회원가입 정보 저장
    @PostMapping("save")
    public String save(UserDto userDto) {
        userService.save(userDto);
        return "redirect:/login";
    }

    @GetMapping("login")
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
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
