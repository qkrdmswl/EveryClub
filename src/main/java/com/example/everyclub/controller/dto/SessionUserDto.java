package com.example.everyclub.controller.dto;

import com.example.everyclub.entity.user.UserEntity;
import lombok.Getter;

@Getter
public class SessionUserDto {
    private String name;
    private String email;

    public SessionUserDto(UserEntity user){
        this.name = user.getUserName();
        this.email = user.getUserEmail();
    }
}
