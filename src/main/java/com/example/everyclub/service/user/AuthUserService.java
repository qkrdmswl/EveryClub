package com.example.everyclub.service.user;

import com.example.everyclub.controller.dto.UserDto;
import com.example.everyclub.entity.user.Role;
import com.example.everyclub.entity.user.UserEntity;
import com.example.everyclub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByUserEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public Long save(UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setUserPassword(encoder.encode(userDto.getUserPassword()));

        return userRepository.save(UserEntity.builder()
                .email(userDto.getUserEmail())
                .role(Role.USER)
                .password(userDto.getUserPassword())
                .phone(userDto.getUserPhone())
                .name(userDto.getUserName())
                .build()).getUserId();
    }
}
