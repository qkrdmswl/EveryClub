package com.example.everyclub.entity.club;

import com.example.everyclub.entity.user.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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
