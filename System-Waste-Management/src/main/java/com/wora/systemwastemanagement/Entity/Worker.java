package com.wora.systemwastemanagement.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worker")
    public class Worker extends Utilisateur {

        @Column(nullable = true)
        private Double salaire;
        @Column(nullable = false)
        private LocalDateTime hire_date;
        @Column(nullable = true)
        private String contact_info;
        @Column(nullable = false)
        @NotNull
        private String job_title;

        @OneToMany(mappedBy = "assignedWorker" , fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
        private List<Vehicule> vehiculeList;

        @OneToMany(mappedBy = "worker" , fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
        @JsonIgnore
        private List<Task> taskList;
    }
