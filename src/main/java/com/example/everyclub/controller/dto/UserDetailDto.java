package com.example.everyclub.controller.dto;

import com.example.everyclub.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
// 모든 생성자들은 쓰이는 일이 없어도 만들어놔도 문제 없음
public class UserDetailDto {
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhone;
    private LocalDateTime userRegdate;

    public static UserDetailDto toUserDetailDto(UserEntity userEntity) {
        UserDetailDto userDetailDto = new UserDetailDto();
        userDetailDto.setUserId(userEntity.getUserId());
        userDetailDto.setUserEmail(userEntity.getUserEmail());
        userDetailDto.setUserPassword(userEntity.getUserPassword());
        userDetailDto.setUserName(userEntity.getUserName());
        return userDetailDto;
    }

    public static List<UserDetailDto> change(List<UserEntity> userEntityList) {
        List<UserDetailDto> userDetailDtoList = new ArrayList<>();

        for (UserEntity m: userEntityList) {
            userDetailDtoList.add(toUserDetailDto(m));
        }
        return userDetailDtoList;
    }
}
