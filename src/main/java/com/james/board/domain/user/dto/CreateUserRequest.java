package com.james.board.domain.user.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private int age;
}
