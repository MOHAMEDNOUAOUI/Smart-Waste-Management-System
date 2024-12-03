package com.wora.systemwastemanagement.DTO.Complaint;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseComplaintDTO {

    private Long id;
    private String description;
    private Integer priority;
    private String comment;
    private LocalDateTime created_at;
    private LocalDateTime resolved_at;
}