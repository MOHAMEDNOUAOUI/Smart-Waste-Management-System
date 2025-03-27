package com.wora.systemwastemanagement.DTO.Vehicule;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVehiculeDTO {
    @NotBlank
    private String vehicule_number;

    @NotNull
    private Integer capacity;

    @NotNull
    private Double location_longitude;

    @NotNull
    private Double location_latitude;

    @NotNull
    private Long worker_id;
}
