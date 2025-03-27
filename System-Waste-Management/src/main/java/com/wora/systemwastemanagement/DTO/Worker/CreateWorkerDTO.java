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
    private Double salaire = 0.0;
    @NotNull
    private LocalDateTime hire_date = LocalDateTime.now();
    @NotNull
    private String contact_info = "N/A";
    @NotNull
    private String job_title = "Worker";

}