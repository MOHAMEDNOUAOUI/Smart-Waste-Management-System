package com.wora.systemwastemanagement.DTO.Roots;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRootsDTO {

    @NotNull
    private Long BinsId;
    @NotNull
    private Long VehiculeId;
    @NotNull
    private LocalDateTime start_time;
    @NotNull
    private LocalDateTime end_time;
    @NotNull
    private Float distance;

}