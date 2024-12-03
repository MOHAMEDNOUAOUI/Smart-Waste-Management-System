package com.wora.systemwastemanagement.DTO.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUtilisateurDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
}
