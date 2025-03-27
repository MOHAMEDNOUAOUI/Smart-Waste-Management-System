package com.wora.systemwastemanagement.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
import com.wora.systemwastemanagement.Entity.Enum.TypeTask;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String taskName;

    @NotNull
    private String taskDescription;

    @NotNull
    private Integer priority;

    @NotNull
    private LocalDateTime created_time;

    @NotNull
    private LocalDateTime due_date;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeTask type_task;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatut taskStatus;

    @ManyToOne
    @JsonIgnore
    private Worker worker;
}
