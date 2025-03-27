package com.wora.systemwastemanagement.DTO.Roots;

import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsForRoots;
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
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRootsEmbdDTO {
    private Long id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Float distance;
    private List<ResponseBinsForRoots> bins;
    private List<ResponseRootsEmbdDTO> routes;
}
