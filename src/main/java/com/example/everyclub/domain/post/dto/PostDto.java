package com.example.everyclub.domain.post.dto;

import com.example.everyclub.domain.post.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private String postTitle;
    private String postContent;

    public PostDto(PostEntity post) {
        this.postTitle = post.getPostTitle();
        this.postContent = post.getPostContent();
    }
}
