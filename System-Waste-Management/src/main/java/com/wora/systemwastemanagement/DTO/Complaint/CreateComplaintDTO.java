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
public class CreateComplaintDTO {

    @NotBlank
    private String description;
    @NotNull
    private Integer priority;
    @NotBlank
    private String comment;
    @NotNull
    private LocalDateTime created_at = LocalDateTime.now();

}