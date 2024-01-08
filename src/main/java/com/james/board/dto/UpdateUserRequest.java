package com.james.board.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String email;
    private int age;
}
