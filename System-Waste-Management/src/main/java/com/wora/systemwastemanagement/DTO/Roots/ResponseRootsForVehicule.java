package com.wora.systemwastemanagement.DTO.Roots;

import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsForRoots;
import com.wora.systemwastemanagement.Entity.Embd.RootsIds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRootsForVehicule {
    private RootsIds rootsIds;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private Float distance;
    private List<ResponseBinsForRoots> bins;
}
