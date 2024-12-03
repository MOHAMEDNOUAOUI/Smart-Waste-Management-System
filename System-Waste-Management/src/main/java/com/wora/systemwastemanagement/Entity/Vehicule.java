package com.wora.systemwastemanagement.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.jdbc.Work;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vehicule_number", nullable = false)
    @NotBlank
    private String vehicule_number;
    @NotNull
    private Integer capacity;
    @Column(name = "location_longitude")
    private Double location_longitude;
    @Column(name = "location_latitude")
    private Double location_latitude;

    @ManyToOne(fetch = FetchType.EAGER)
    private Worker worker;
}
