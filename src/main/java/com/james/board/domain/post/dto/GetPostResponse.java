package com.james.board.domain.post.dto;

import lombok.Data;

@Data
public class GetPostResponse {
    private Long postId;
    private String title;
    private String content;

    public GetPostResponse(Long postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

}
