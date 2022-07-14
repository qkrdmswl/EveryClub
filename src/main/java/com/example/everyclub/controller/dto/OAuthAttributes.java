package com.example.everyclub.controller.dto;

import com.example.everyclub.entity.user.Role;
import com.example.everyclub.entity.user.UserEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String snsId;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String phone, String snsId) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.userName = name;
        this.userEmail = email;
        this.userPhone = phone;
        this.snsId = snsId;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        //  이곳에서 Naver Kakao Google 등 구분 ex) ofNaver ofKakao ofGoogle

        if("naver".equals(registrationId)) {
            return ofNaver(userNameAttributeName, attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");

        return OAuthAttributes.builder()
                .email((String) response.get("email"))
                .name((String) response.get("name"))
                .snsId((String) response.get("id"))
                .phone((String) response.get("mobile"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(userEmail)
                .name(userName)
                .snsId(snsId)
                .phone(userPhone)
                .role(Role.SOCIAL)
                .build();
    }
}
