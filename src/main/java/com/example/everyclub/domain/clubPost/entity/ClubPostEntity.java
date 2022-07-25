package com.example.everyclub.domain.clubPost.entity;

import com.example.everyclub.global.entity.BaseTimeEntity;
import com.example.everyclub.domain.club.entity.ClubEntity;
import com.example.everyclub.domain.auth.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="ClubPost")
public class ClubPostEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clubPostId", unique = true)
    private Long clubPostId;

    @ManyToOne
    @JoinColumn(name = "club")
    private ClubEntity club;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Column(name = "clibPostContent", columnDefinition = "TEXT", nullable = false)
    private String clubPostContent;

    @Column(name = "postViews", nullable = false)
    private Integer clubPostViews;
}