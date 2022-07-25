package com.example.everyclub.domain.auth.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // class 내 모든 필드의 Getter 메소드 자동 생성
@RequiredArgsConstructor // final이나 NonNull인 필드 값만 파라미터로 받는 생성자 추가
public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    SOCIAL("ROLE_SOCIAL"); // OAuth

    private final String value;
}
