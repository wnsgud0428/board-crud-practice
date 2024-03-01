package com.james.board.dto;

import lombok.Data;

@Data
public class DeleteUserResponse {
    private Long id;
    private String name;
    private Boolean isDeleted;

    public DeleteUserResponse(Long id, String name, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
    }
}
