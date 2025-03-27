package com.wora.systemwastemanagement.DTO.Complaint;

import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import com.wora.systemwastemanagement.Entity.Enum.StatutComplaint;
import com.wora.systemwastemanagement.Entity.Media;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintEmbd {
    private Long id;
    private String description;
    private Integer priority;
    private String comment;
    private LocalDateTime created_at;
    private LocalDateTime resolved_at;
    private StatutComplaint status;
    private List<Media> mediaList;
    private ResponseBinsDTO bins;
}
