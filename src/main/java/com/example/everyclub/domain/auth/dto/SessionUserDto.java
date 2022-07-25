package com.example.everyclub.domain.auth.dto;

import com.example.everyclub.domain.auth.entity.UserEntity;
import lombok.Getter;

@Getter
public class SessionUserDto {
    private String name;
    private String email;

    public SessionUserDto(UserEntity user){
        this.name = user.getUsername();
        this.email = user.getUserEmail();
    }
}
