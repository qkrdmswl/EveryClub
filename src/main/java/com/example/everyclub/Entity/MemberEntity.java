package com.example.everyclub.Entity;

import com.example.everyclub.DTO.MemberSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="member_table")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50, unique = true)
    private String memberEmail;  // Entity에서는 _(언더바) 금지. 오류 발생 가능성 있음

    @Column(length = 20)
    private String memberPassword;

    @Column()
    private String memberName;

    public static MemberEntity saveMember(MemberSaveDTO memberSaveDTO) {
        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setMemberEmail(memberSaveDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberSaveDTO.getMemberPassword());
        memberEntity.setMemberName(memberSaveDTO.getMemberName());

        return memberEntity;
    }
}
