package com.james.board.domain.post.dto;

import lombok.Data;

@Data
public class EditPostRequest {
    private String newTitle;
    private String newContent;
}
