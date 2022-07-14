package com.example.everyclub.service.user;

import com.example.everyclub.controller.dto.UserDetailDto;
import com.example.everyclub.controller.dto.UserLoginDto;
import com.example.everyclub.controller.dto.UserSaveDto;
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

    // 회원가입 정보 저장
    @Override
    public Long save(UserSaveDto memberSaveDTO) {
    // JPARepository는 무조건 Entity 타입만 받기 때문에 DTO를 Entity 타입으로 바꿔줘야 함
    // 사용자가 데이터 입력 -> DTO 형태로 Controller에게 전달 -> DTO를 Entity 타입으로 바꿔서 ?
        UserEntity userEntity = UserEntity.saveMember(memberSaveDTO);
        return userRepository.save(userEntity).getUserId();
    }

   @Override
    public boolean login(UserLoginDto userLoginDto) {
        UserEntity userEntity = userRepository.findByUserEmail(userLoginDto.getUserEmail()).get();
        if (userEntity != null) {
            if(userEntity.getUserPassword().equals(userLoginDto.getUserPassowrd())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<UserDetailDto> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDetailDto> userDetailDtoList = UserDetailDto.change(userEntityList);
        return userDetailDtoList;
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
