package com.example.everyclub.service.member;

import com.example.everyclub.controller.member.dto.MemberDetailDTO;
import com.example.everyclub.controller.member.dto.MemberLoginDTO;
import com.example.everyclub.controller.member.dto.MemberSaveDTO;

import java.util.List;

public interface MemberService {

    Long save(MemberSaveDTO memberSaveDTO);
    boolean login(MemberLoginDTO memberLoginDTO);
    List<MemberDetailDTO> findAll();
    MemberDetailDTO findById(Long memberId);
    void deleteById(Long memberId);
}
