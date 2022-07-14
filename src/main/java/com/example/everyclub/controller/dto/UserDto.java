package com.example.everyclub.controller.dto;

import com.example.everyclub.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhone;

    public UserDto(UserEntity user) {
        this.userId = user.getUserId();
        this.userEmail = user.getUserEmail();
        this.userPassword = user.getUserPassword();
        this.userName = user.getUserName();
        this.userPhone = user.getUserPhone();
    }

}
