package com.wora.systemwastemanagement.DTO.Worker;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWorkerDTO {
    private Long id;
    private Double salaire;
    private LocalDateTime hire_date;
    private String contact_info;
    private String job_title;
}