package com.example.everyclub.domain.post.service;

import com.example.everyclub.domain.post.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();
    List<PostDto> findPostByUser(Long userId);
    PostDto findPost(Long postId);
    Integer updateView(Long postId);
    PostDto addPost(Long userId, PostDto postDto);
    PostDto updatePost(Long userId, Long postId, PostDto postDto);
    void deletePost(Long userId, Long postId);
}
