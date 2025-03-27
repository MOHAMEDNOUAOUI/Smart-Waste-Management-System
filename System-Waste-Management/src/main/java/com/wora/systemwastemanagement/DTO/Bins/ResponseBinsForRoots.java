package com.wora.systemwastemanagement.DTO.Bins;

import com.wora.systemwastemanagement.Entity.Complaint;
import com.wora.systemwastemanagement.Entity.Roots;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBinsForRoots {
    private Long id;
    private String location;
    private Double capacity;
    private Float location_latitude;
    private Float location_longitude;
    private LocalDateTime last_maintenance;
}
