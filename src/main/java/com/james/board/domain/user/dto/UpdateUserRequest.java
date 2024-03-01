package com.james.board.domain.user.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String email;
    private int age;
}
