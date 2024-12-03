package com.wora.systemwastemanagement.DTO.Bins;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBinsDTO {

    @NotBlank
    private String location;
    @NotNull
    private Double capacity;
    @NotNull
    private Float location_latitude;
    @NotNull
    private Float location_longitude;

}