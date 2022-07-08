package com.example.everyclub.service;

import com.example.everyclub.DTO.MemberSaveDTO;
import com.example.everyclub.Entity.MemberEntity;
import com.example.everyclub.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    // Repository 생성자 주입.
    private final MemberRepository memberRepository;

    // 회원가입 정보 저장
    @Override
    public Long save(MemberSaveDTO memberSaveDTO) {
    // JPARepository는 무조건 Entity 타입만 받기 때문에 DTO를 Entity 타입으로 바꿔줘야 함
    // 사용자가 데이터 입력 -> DTO 형태로 Controller에게 전달 -> DTO를 Entity 타입으로 바꿔서 ?
        MemberEntity memberEntity = MemberEntity.saveMember(memberSaveDTO);
        return memberRepository.save(memberEntity).getId();
    }
}
