package com.wora.systemwastemanagement.Entity;
import com.wora.systemwastemanagement.Entity.Enum.StatutComplaint;
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
@Table(name = "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private Integer priority;
    @NotBlank
    private String comment;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private LocalDateTime resolved_at;
    @Enumerated(EnumType.STRING)
    private StatutComplaint status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToMany(mappedBy = "complaint" , fetch = FetchType.EAGER)
    private List<Media> mediaList;

    @ManyToOne(fetch = FetchType.EAGER)
    private Bins bins;
}
