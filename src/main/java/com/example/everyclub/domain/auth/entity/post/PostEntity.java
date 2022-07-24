package com.example.everyclub.entity.post;

import com.example.everyclub.entity.BaseTimeEntity;
import com.example.everyclub.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="Post")
public class PostEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId", unique = true)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    @Column(name = "postContent", columnDefinition = "TEXT", nullable = false)
    private String postContent;

    @Column(name = "postViews", nullable = false)
    private Integer postViews;
}
