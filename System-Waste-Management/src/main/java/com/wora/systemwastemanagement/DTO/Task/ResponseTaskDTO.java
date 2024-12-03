package com.wora.systemwastemanagement.DTO.Task;

import com.wora.systemwastemanagement.Entity.Enum.TypeTask;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTaskDTO {

    private Long id;

    private Integer priority;

    private LocalDateTime due_date;

    private TypeTask type_task;

}