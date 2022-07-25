package com.example.everyclub.domain.club.entity;

import com.example.everyclub.domain.auth.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Club")
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clubId", unique = true)
    private Long clubId;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Column(name = "clubName", length = 100, nullable = false)
    private String clubName;

    @Column(name = "clubMaxMember", nullable = false)
    private Integer clubMaxMember;

    @Column(name = "clubMembers", nullable = false)
    private Integer clubMembers;

    @Column(name = "clubDescription", length = 400)
    private String clubDescription;

    @Column(name = "clubType", length = 200, nullable = false)
    private String clubType;

    @Column(name = "clubPublic", nullable = false)
    private boolean clubPublic;
}
