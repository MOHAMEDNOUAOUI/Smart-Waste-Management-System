package com.wora.systemwastemanagement.DTO.Client;

import com.wora.systemwastemanagement.DTO.Complaint.ComplaintEmbd;
import com.wora.systemwastemanagement.DTO.Utilisateur.ResponseUtilisateurDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseClientDTO extends ResponseUtilisateurDTO {
    private List<ComplaintEmbd> complaintList;
}