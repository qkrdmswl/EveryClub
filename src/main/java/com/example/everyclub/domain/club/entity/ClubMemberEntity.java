package com.example.everyclub.domain.club.entity;

import com.example.everyclub.domain.auth.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ClubMembers")
public class ClubMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "club")
    private ClubEntity club;

    @Column(name = "clubMemberPosition", length = 20, nullable = false)
    private String clubMemberPosition;
}
