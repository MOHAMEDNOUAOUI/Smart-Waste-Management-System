package com.wora.systemwastemanagement.DTO.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUtilisateurDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String rrole;
    private LocalDate birthday;
    private LocalDateTime created_at;
}
