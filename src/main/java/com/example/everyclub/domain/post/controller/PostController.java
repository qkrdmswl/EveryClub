package com.example.everyclub.domain.post.controller;

import com.example.everyclub.common.ApiResponse;
import com.example.everyclub.domain.auth.entity.UserEntity;
import com.example.everyclub.domain.post.dto.PostDto;
import com.example.everyclub.domain.post.service.PostService;
import com.example.everyclub.global.config.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/read/{postId}")
    public ApiResponse<PostDto> read(@PathVariable Long postId, Model model) {
        postService.updateView(postId);
        model.addAttribute("post", postService.findPost(postId));
        return new ApiResponse<>(postService.findPost(postId));
    }

    @GetMapping("/all")
    public ApiResponse<List<PostDto>> findAllPosts() {
        return new ApiResponse<>(postService.findAllPosts());
    }

    @GetMapping("/{postId}")
    public ApiResponse<PostDto> findPostById(@PathVariable Long postId) {
        return new ApiResponse<>(postService.findPost(postId));
    }

    @GetMapping("/user") // Security 에 저장된 현재 유저 정보를 토대로 게시글 탐색
    public ApiResponse<List<PostDto>> findPostByUser (@CurrentUser UserEntity user) {
        return new ApiResponse<>(postService.findPostByUser(user.getUserId()));
    }
    @GetMapping("/user/{userId}") // 유저 아이디로 게시글 탐색
    public ApiResponse<List<PostDto>> findPostByUserId (@PathVariable Long userId) {
        return new ApiResponse<>(postService.findPostByUser(userId));
    }

    @PostMapping("/add")
    public ApiResponse<PostDto> addPost(@CurrentUser UserEntity user, @RequestBody PostDto postDto) {
        return new ApiResponse<>(postService.addPost(user.getUserId(), postDto));
    }

    @PostMapping("/add/{userId}")
    public ApiResponse<PostDto> addPostByUserId(@PathVariable Long userId, @RequestBody PostDto postDto) {
        return new ApiResponse<>(postService.addPost(userId, postDto));
    }

    @PutMapping("/update/{postId}")
    public ApiResponse<PostDto> updatePost(@CurrentUser UserEntity user, @PathVariable Long postId, @RequestBody PostDto postDto) {
        return new ApiResponse<>(postService.updatePost(user.getUserId(), postId, postDto));
    }

    @DeleteMapping("/delete/{postId}")
    public void deletePost(@CurrentUser UserEntity user, @PathVariable Long postId) {
        postService.deletePost(user.getUserId(), postId);
    }
}
