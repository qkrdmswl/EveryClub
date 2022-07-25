package com.example.everyclub.domain.post.repository;

import com.example.everyclub.domain.auth.entity.UserEntity;
import com.example.everyclub.domain.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUser(UserEntity user);

    @Modifying
    @Query(value = "update Post set postViews = postViews + 1 where postId = :postId", nativeQuery = true)
    Integer updateView(Long postId);
}
