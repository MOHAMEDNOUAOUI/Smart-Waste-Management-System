package com.wora.systemwastemanagement.DTO.Task;

import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
import com.wora.systemwastemanagement.Entity.Enum.TypeTask;
import com.wora.systemwastemanagement.Entity.Worker;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTaskForWorker {
    private Long id;
    private String taskName;
    private String taskDescription;
    private Integer priority;
    private LocalDateTime created_time;
    private LocalDateTime due_date;
    private TypeTask type_task;
    private TaskStatut taskStatus;
}
