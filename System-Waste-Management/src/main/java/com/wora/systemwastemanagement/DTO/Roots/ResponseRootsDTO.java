package com.wora.systemwastemanagement.DTO.Roots;

import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeForWorker;
import com.wora.systemwastemanagement.Entity.Bins;
import com.wora.systemwastemanagement.Entity.Embd.RootsIds;
import com.wora.systemwastemanagement.Entity.Vehicule;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRootsDTO {
    private Long id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Float distance;
    private List<ResponseBinsDTO> bins;
    private ResponseVehiculeForWorker vehicule;
}
