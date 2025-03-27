package com.wora.systemwastemanagement.Service;

import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import com.wora.systemwastemanagement.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.systemwastemanagement.DTO.Utilisateur.ResponseUtilisateurDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {
    ResponseUtilisateurDTO createAdmin(CreateUtilisateurDTO createUtilisateurDTO);
    Page<ResponseUtilisateurDTO> getAllAdmins(Pageable pageable);
    ResponseUtilisateurDTO getAdminById(Long id);
    ResponseUtilisateurDTO updateClient(CreateUtilisateurDTO createUtilisateurDTO , Long id);
    void deleteAdmin(Long id);
}
