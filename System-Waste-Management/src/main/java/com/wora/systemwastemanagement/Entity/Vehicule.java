package com.wora.systemwastemanagement.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.jdbc.Work;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vehicule_number", nullable = false, unique = true)
    @NotBlank
    private String vehicule_number;
    @NotNull
    private Integer capacity;
    @Column(name = "location_longitude")
    private Double location_longitude;
    @Column(name = "location_latitude")
    private Double location_latitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker assignedWorker;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Roots> routes;
}
