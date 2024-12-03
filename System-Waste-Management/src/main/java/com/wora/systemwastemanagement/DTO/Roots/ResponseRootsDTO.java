package com.wora.systemwastemanagement.DTO.Roots;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRootsDTO {

    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Float distance;

}