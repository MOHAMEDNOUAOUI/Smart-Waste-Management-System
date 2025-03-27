package com.wora.systemwastemanagement.DTO.Roots;

import com.wora.systemwastemanagement.DTO.Bins.CreateBinsDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRootsDTO {

    @NotNull
    private List<CreateBinsDTO> bins;
    @NotNull
    private Long VehiculeId;
    @NotNull
    private LocalDateTime start_time;
    @NotNull
    private LocalDateTime end_time;
    @NotNull
    private Float distance;

}