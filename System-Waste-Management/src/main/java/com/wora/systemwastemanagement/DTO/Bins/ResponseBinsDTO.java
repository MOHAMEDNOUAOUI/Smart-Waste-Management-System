package com.wora.systemwastemanagement.DTO.Bins;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBinsDTO {

    private Long id;
    private String location;
    private Double capacity;
    private Float location_latitude;
    private Float location_longitude;

}