package com.example.everyclub.domain.post.service;

import com.example.everyclub.domain.auth.entity.UserEntity;
import com.example.everyclub.domain.auth.repository.UserRepository;
import com.example.everyclub.domain.post.dto.PostDto;
import com.example.everyclub.domain.post.entity.PostEntity;
import com.example.everyclub.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements  PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<PostDto> findAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostDto> findPostByUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        return postRepository.findByUser(user)
                .stream().map(PostDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostDto findPost(Long postId) {
        PostEntity post = postRepository.findById(postId).orElseThrow();
        return new PostDto(post);
    }

    @Transactional
    public Integer updateView(Long postId) {
        return postRepository.updateView(postId);
    }

    @Transactional
    public PostDto addPost(Long userId, PostDto postDto) {
        UserEntity user = userRepository.findById(userId).orElseThrow();

        PostEntity newPost = PostEntity.builder()
                .user(user)
                .postTitle(postDto.getPostTitle())
                .postContent(postDto.getPostContent())
                .postViews(0)
                .build();
        return new PostDto(postRepository.save(newPost));
    }

    private boolean checkAccessOfPost(Long userId, Long postId) {
        return postRepository.findById(postId).orElseThrow().getUser().getUserId().equals(userId);
    }

    @Transactional
    public PostDto updatePost(Long userId, Long postId, PostDto postDto) {
        PostEntity modifiedPost = postRepository.findById(postId).orElseThrow();
        modifiedPost.update(postDto.getPostTitle(), postDto.getPostContent());
        return new PostDto(modifiedPost);
    }

    public void deletePost(Long userId, Long postId) {
        PostEntity deletePost = postRepository.findById(postId).orElseThrow();

        postRepository.deleteById(deletePost.getPostId());
    }
}
