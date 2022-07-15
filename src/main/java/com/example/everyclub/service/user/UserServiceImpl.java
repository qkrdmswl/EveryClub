package com.example.everyclub.service.user;

import com.example.everyclub.controller.dto.UserDetailDto;
import com.example.everyclub.entity.user.UserEntity;
import com.example.everyclub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // Repository 생성자 주입.
    private final UserRepository userRepository;

    @Override
    public List<UserDetailDto> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return UserDetailDto.change(userEntityList);
    }

    @Override
    public UserDetailDto findById(Long userId) {
        return UserDetailDto.toUserDetailDto(userRepository.findById(userId).get());
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
