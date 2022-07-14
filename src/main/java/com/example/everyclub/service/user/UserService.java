package com.example.everyclub.service.user;

import com.example.everyclub.controller.dto.UserDetailDto;
import com.example.everyclub.controller.dto.UserLoginDto;
import com.example.everyclub.controller.dto.UserSaveDto;

import java.util.List;

public interface UserService {

    Long save(UserSaveDto userSaveDto);
    boolean login(UserLoginDto userLoginDto);
    List<UserDetailDto> findAll();
    UserDetailDto findById(Long userId);
    void deleteById(Long userId);
}
