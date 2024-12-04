package com.wora.systemwastemanagement.DTO;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}