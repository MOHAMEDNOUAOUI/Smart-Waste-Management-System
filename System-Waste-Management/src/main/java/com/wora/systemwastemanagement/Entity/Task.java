package com.wora.systemwastemanagement.Entity;
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
    private Integer priority;

    @NotNull
    private LocalDateTime due_date;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private TypeTask type_task;

    @ManyToOne()
    private Worker worker;
}
