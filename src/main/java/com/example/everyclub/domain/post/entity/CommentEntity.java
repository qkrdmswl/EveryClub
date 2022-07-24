package com.example.everyclub.domain.post.entity;

import com.example.everyclub.global.entity.BaseTimeEntity;
import com.example.everyclub.domain.auth.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Comment")
public class CommentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentId", unique = true)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post")
    private PostEntity post;

    @Column(name = "commentContent", length = 400, nullable = false)
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "parentComment")
    private CommentEntity parentComment;
}
