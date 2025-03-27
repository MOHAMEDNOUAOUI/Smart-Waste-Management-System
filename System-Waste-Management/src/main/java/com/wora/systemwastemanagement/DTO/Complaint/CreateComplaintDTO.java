package com.wora.systemwastemanagement.DTO.Complaint;

import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;
import com.wora.systemwastemanagement.Entity.Enum.StatutComplaint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

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
    private StatutComplaint status = StatutComplaint.PENDING;
    @NotNull
    private Long bin;
    @NotNull
    private Long client_id;

}