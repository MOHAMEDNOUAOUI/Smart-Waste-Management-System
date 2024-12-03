package com.wora.systemwastemanagement.DTO.Task;

import com.wora.systemwastemanagement.Entity.Enum.TypeTask;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDTO {

    @NotNull
    private Integer priority;

    @NotNull
    private LocalDateTime due_date;

    @NotBlank
    private TypeTask type_task;


}