package com.wora.systemwastemanagement.DTO.Utilisateur;


import com.wora.systemwastemanagement.Entity.Enum.Rrole;
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
    @NotBlank(message = "email must not be null")
    @Email(message = "email is already in use")
    private String email;
    @NotBlank
    private Rrole rrole;
}

