package com.wora.systemwastemanagement.DTO.Task;

import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
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
    private Long workerId;

    @NotNull
    private String taskName;

    @NotNull
    private String taskDescription;

    @NotNull
    private Integer priority;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatut taskStatus;

    private LocalDateTime created_time = LocalDateTime.now();

    private LocalDateTime due_date;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeTask type_task;


}