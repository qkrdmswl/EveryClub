package com.example.everyclub.entity;

import com.example.everyclub.controller.dto.UserSaveDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", unique = true)
    private Long userId;

    @Column(length = 100)
    private String userEmail;  // Entity에서는 _(언더바) 금지. 오류 발생 가능성 있음

    @Column(length = 20)
    private String userPassword;

    @Column(length = 100)
    private String userName;

    @Column(length = 20)
    private String userPhone;

    @Column()
    private LocalDateTime userRegdate;

    public static UserEntity saveMember(UserSaveDto userSaveDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserEmail(userSaveDto.getUserEmail());
        userEntity.setUserPassword(userSaveDto.getUserPassword());
        userEntity.setUserName(userSaveDto.getUserName());

        return userEntity;
    }
}
