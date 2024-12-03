package com.wora.systemwastemanagement.Entity.Embd;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class RootsIds {
    @Column(name = "bins_id")
    private Long BinsId;

    @Column(name = "vehicule_id")
    private Long VehiculeId;
}
