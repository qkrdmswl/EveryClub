package com.example.everyclub.entity.clubPost;

import com.example.everyclub.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ClubPostLike")
public class ClubLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;


    @ManyToOne
    @JoinColumn(name = "clubPost")
    private ClubPostEntity clubPost;
}
