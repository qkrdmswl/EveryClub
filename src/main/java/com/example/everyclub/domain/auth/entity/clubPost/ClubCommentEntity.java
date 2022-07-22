package com.example.everyclub.entity.clubPost;

import com.example.everyclub.entity.BaseTimeEntity;
import com.example.everyclub.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ClubPostComment")
public class ClubCommentEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clubCommentId", unique = true)
    private Long clubCommentId;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "clubPost")
    private ClubPostEntity clubPost;


    @Column(name = "clubCommentContent", length = 400, nullable = false)
    private String clubCommentContent;

    @ManyToOne
    @JoinColumn(name = "clubParentComment")
    private ClubCommentEntity clubParentComment;
}
