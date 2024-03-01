package com.james.board.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private int age;
}
