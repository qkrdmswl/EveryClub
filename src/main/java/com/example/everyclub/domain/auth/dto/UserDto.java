package com.example.everyclub.domain.auth.dto;

import com.example.everyclub.domain.auth.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhone;

    public UserDto(UserEntity user) {
        this.userEmail = user.getUserEmail();
        this.userPassword = user.getUserPassword();
        this.userName = user.getUsername();
        this.userPhone = user.getUserPhone();
    }

}
