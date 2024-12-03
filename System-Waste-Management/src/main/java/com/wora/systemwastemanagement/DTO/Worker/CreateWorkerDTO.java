package com.wora.systemwastemanagement.DTO.Worker;

import com.wora.systemwastemanagement.DTO.Utilisateur.CreateUtilisateurDTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkerDTO extends CreateUtilisateurDTO {

    @NotNull
    private Double salaire;
    @NotNull
    private LocalDateTime hire_date;
    @NotNull
    private String contact_info;
    @NotNull
    private String job_title;

}