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
public class ResponseVehiculeDTO {

    private Long id;
    private String vehicule_number;
    private Integer capacity;
    private Double location_longitude;
    private Double location_latitude;
}