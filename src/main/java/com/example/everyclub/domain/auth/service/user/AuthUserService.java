package com.example.everyclub.service.user;

import com.example.everyclub.controller.dto.SignUserRequest;
import com.example.everyclub.controller.dto.SignUserResponse;
import com.example.everyclub.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AuthUserService  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SignUserResponse save(SignUserRequest userDto) {
        return new SignUserResponse(userRepository.save(userDto.toEntity(passwordEncoder)).getUserId());
    }
}
