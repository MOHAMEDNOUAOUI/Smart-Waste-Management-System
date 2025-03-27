package com.wora.systemwastemanagement.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wora.systemwastemanagement.Entity.Embd.RootsIds;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roots")
public class Roots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime start_time;

    @NotNull
    private LocalDateTime end_time;

    @NotNull
    private Float distance;

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Bins> bins;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Vehicule vehicule;
}
