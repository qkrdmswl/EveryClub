package com.example.everyclub.controller.dto;

import com.example.everyclub.entity.user.Role;
import com.example.everyclub.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUserRequest {
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhone;

    public UserEntity toEntity(PasswordEncoder passwordEncoder) {
        return UserEntity.builder()
                .email(userEmail)
                .role(Role.USER)
                .password(passwordEncoder.encode(userPassword))
                .phone(userPhone)
                .name(userName)
                .build();
    }
}
