package com.wora.systemwastemanagement.DTO.Task;

import com.wora.systemwastemanagement.DTO.Worker.WorkerForTask;
import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
import com.wora.systemwastemanagement.Entity.Enum.TypeTask;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTask {

    private Long id;
    private String taskName;
    private String taskDescription;
    private Integer priority;
    private TaskStatut taskStatus;
    private LocalDateTime due_date;
    private TypeTask type_task;
    private WorkerForTask worker;

}
