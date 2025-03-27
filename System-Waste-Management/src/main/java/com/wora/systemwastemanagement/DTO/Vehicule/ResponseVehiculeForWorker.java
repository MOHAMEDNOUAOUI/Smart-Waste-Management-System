package com.wora.systemwastemanagement.DTO.Vehicule;

import com.wora.systemwastemanagement.DTO.Roots.ResponseRootsEmbdDTO;
import com.wora.systemwastemanagement.DTO.Worker.WorkerForTask;
import com.wora.systemwastemanagement.Entity.Roots;
import com.wora.systemwastemanagement.Entity.Worker;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVehiculeForWorker {
    private Long id;
    private String vehicule_number;
    private Integer capacity;
    private Double location_longitude;
    private Double location_latitude;
    private WorkerForTask assignedWorker;
}
