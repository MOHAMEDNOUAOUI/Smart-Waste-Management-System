package com.wora.systemwastemanagement.DTO.Vehicule;

import com.wora.systemwastemanagement.DTO.Roots.ResponseRootsEmbdDTO;
import com.wora.systemwastemanagement.DTO.Worker.WorkerForTask;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.Lint;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVehiculeDTO {

    private Long id;
    private String vehicule_number;
    private Integer capacity;
    private Double location_longitude;
    private Double location_latitude;
    private WorkerForTask assignedWorker;
    private List<ResponseRootsEmbdDTO> routes;
}