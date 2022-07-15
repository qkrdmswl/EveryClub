package com.example.everyclub.entity.user;

import com.example.everyclub.controller.dto.UserSaveDto;
import com.example.everyclub.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="User")
@NoArgsConstructor
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", unique = true)
    private Long userId;

    @Column(name = "userEmail", length = 100, unique = true)
    private String userEmail;  // Entity에서는 _(언더바) 금지. 오류 발생 가능성 있음

    @Column(name = "snsId", length = 255)
    private String snsId;

    @Column(name = "userPassword", length = 20)
    private String userPassword;

    @Column(name = "userName", length = 100)
    private String userName;

    @Column(name = "userPhone", length = 20)
    private String userPhone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public UserEntity(Long id, String email, String name, String phone, Role role, String snsId) {
        this.userId = id;
        this.userName = name;
        this.userEmail = email;
        this.userPhone = phone;
        this.role = role;
        this.snsId = snsId;
    }

    public UserEntity update(String name, String password, String phone) {
        this.userName = name;
        this.userPassword = password;
        this.userPhone = phone;
        return this;
    }

    public UserEntity updateSnsLogin() {
        return this;
    }

    public String getRoleValue() {
        return this.role.getValue();
    }

    public static UserEntity saveMember(UserSaveDto userSaveDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserEmail(userSaveDto.getUserEmail());
        userEntity.setUserPassword(userSaveDto.getUserPassword());
        userEntity.setUserName(userSaveDto.getUserName());
        userEntity.setUserPhone(userSaveDto.getUserPhone());

        return userEntity;
    }
}
