package com.wora.systemwastemanagement.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Username is required")
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true , nullable = false)
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "created_at" , nullable = false)
    private LocalDateTime created_at;
}
