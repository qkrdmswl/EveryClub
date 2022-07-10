package com.example.everyclub.service.member;

import com.example.everyclub.controller.member.dto.MemberDetailDTO;
import com.example.everyclub.controller.member.dto.MemberLoginDTO;
import com.example.everyclub.controller.member.dto.MemberSaveDTO;
import com.example.everyclub.Entity.member.MemberEntity;
import com.example.everyclub.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean login(MemberLoginDTO memberLoginDTO) {
        MemberEntity memberEntity = memberRepository.findByMemberEmail(memberLoginDTO.getMemberEmail());
        if (memberEntity != null) {
            if(memberEntity.getMemberPassword().equals(memberLoginDTO.getMemberPassowrd())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public List<MemberDetailDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDetailDTO> memberDetailDTOList = MemberDetailDTO.change(memberEntityList);
        return memberDetailDTOList;
    }

    @Override
    public MemberDetailDTO findById(Long memberId) {
        return MemberDetailDTO.toMemberDetailDTO(memberRepository.findById(memberId).get());
    }

    @Override
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
