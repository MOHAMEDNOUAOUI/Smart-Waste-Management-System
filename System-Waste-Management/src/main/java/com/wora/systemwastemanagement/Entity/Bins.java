package com.wora.systemwastemanagement.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "bins")
public class Bins {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String location;
    @NotNull
    private Double capacity;
    @NotNull
    private Float location_latitude;
    @NotNull
    private Float location_longitude;

    private LocalDateTime last_maintenance;

    @OneToMany(mappedBy = "bins" , fetch = FetchType.EAGER)
    private List<Complaint> complaintList;

    @OneToMany(mappedBy = "bins" , fetch = FetchType.EAGER)
    private List<Roots> roots;
}
