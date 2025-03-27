package com.wora.systemwastemanagement.Entity.Embd;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class RootsIds implements Serializable {
    @Column(name = "bins_id")
    private Long BinsId;

    @Column(name = "vehicule_id")
    private Long VehiculeId;
}
