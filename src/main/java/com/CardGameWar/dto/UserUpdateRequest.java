package com.CardGameWar.dto;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
}
