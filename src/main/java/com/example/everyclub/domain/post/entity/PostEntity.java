package com.example.everyclub.domain.post.entity;

import com.example.everyclub.global.entity.BaseTimeEntity;
import com.example.everyclub.domain.auth.entity.UserEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@DynamicUpdate
@Table(name="Post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId", unique = true)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Column(name = "postTitle", nullable = false, length = 100)
    private String postTitle;

    @Column(name = "postContent", columnDefinition = "TEXT", nullable = false)
    private String postContent;

    @Column(name = "postViews", nullable = false, columnDefinition = "integer default 0")
    private Integer postViews;

    public void update(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    @Builder
    public PostEntity(Long postId, UserEntity user, String postTitle, String postContent, Integer postViews) {
        this.postId = postId;
        this.user = user;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postViews = postViews;
    }
}
