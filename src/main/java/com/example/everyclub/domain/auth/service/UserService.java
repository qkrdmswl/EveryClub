package com.example.everyclub.domain.auth.service;

import com.example.everyclub.domain.auth.dto.UserDetailDto;

import java.util.List;

public interface UserService {
    List<UserDetailDto> findAll();
    UserDetailDto findById(Long userId);
    void deleteById(Long userId);
}
