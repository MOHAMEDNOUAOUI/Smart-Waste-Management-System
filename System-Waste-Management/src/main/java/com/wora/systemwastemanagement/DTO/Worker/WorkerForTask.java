package com.wora.systemwastemanagement.DTO.Worker;

import com.wora.systemwastemanagement.DTO.Utilisateur.ResponseUtilisateurDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerForTask  extends ResponseUtilisateurDTO {
    private Double salaire;
    private LocalDateTime hire_date;
    private String contact_info;
    private String job_title;
}
