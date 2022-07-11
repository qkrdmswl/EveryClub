package com.example.everyclub.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 생성
public class UserSaveDto {

    private String userEmail;
    private String userPassword;
    private String userName;

}
