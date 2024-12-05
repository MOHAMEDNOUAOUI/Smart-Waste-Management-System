package com.wora.systemwastemanagement.DTO.Utilisateur;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUtilisateurDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank(message = "message must not be null")
    @Email(message = "email is already in use")
    private String email;
}

