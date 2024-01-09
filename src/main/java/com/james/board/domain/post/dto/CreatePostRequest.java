package com.james.board.domain.post.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private Long authorId;
    private String title;
    private String content;
}
