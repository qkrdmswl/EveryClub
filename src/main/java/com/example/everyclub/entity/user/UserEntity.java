package com.example.everyclub.entity.user;

import com.example.everyclub.controller.dto.UserSaveDto;
import com.example.everyclub.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="User")
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", unique = true)
    private Long userId;

    @Column(name = "userEmail", length = 100, nullable = false)
    private String userEmail;  // Entity에서는 _(언더바) 금지. 오류 발생 가능성 있음

    @Column(name = "userPassword", length = 20, nullable = false)
    private String userPassword;

    @Column(name = "userName", length = 100, nullable = false)
    private String userName;

    @Column(name = "userPhone", length = 20, nullable = false)
    private String userPhone;

    public static UserEntity saveMember(UserSaveDto userSaveDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserEmail(userSaveDto.getUserEmail());
        userEntity.setUserPassword(userSaveDto.getUserPassword());
        userEntity.setUserName(userSaveDto.getUserName());
        userEntity.setUserPhone(userSaveDto.getUserPhone());

        return userEntity;
    }
}