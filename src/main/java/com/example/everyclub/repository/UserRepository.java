package com.example.everyclub.repository;

import com.example.everyclub.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserEmail(String userEmail);
}
