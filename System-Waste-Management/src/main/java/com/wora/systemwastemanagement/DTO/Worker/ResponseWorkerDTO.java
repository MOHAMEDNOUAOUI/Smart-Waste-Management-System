package com.wora.systemwastemanagement.DTO.Worker;

import com.wora.systemwastemanagement.DTO.Task.ResponseTaskForWorker;
import com.wora.systemwastemanagement.DTO.Utilisateur.ResponseUtilisateurDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeForWorker;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWorkerDTO extends ResponseUtilisateurDTO {
    private Double salaire;
    private LocalDateTime hire_date;
    private String contact_info;
    private String job_title;
    private List<ResponseTaskForWorker> taskList;
    private List<WorkerForTask> vehiculeList;
}