package com.example.everyclub.service.user;

import com.example.everyclub.controller.dto.UserDetailDto;

import java.util.List;

public interface UserService {
    List<UserDetailDto> findAll();
    UserDetailDto findById(Long userId);
    void deleteById(Long userId);
}
