package com.wora.systemwastemanagement.Entity;
import com.wora.systemwastemanagement.Entity.Embd.RootsIds;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roots")
public class Roots {
    @EmbeddedId
    private RootsIds rootsIds;

    @NotNull
    private LocalDateTime start_time;
    @NotNull
    private LocalDateTime end_time;
    @NotNull
    private Float distance;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("BinsId")
    private Bins bins;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("VehiculeId")
    private Vehicule vehicule;
}
