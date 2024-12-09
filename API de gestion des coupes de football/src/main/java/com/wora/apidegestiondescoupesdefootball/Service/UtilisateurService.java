package com.wora.apidegestiondescoupesdefootball.Service;
import com.wora.apidegestiondescoupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.apidegestiondescoupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  UtilisateurService {

    ResponseUtilisateurDTO createUtilisateur(CreateUtilisateurDTO createUtilisateurDTO);
    Page<ResponseUtilisateurDTO> getAllUtilisateurs(Pageable pageable);
    ResponseUtilisateurDTO getUtilisateurById(Long id);
    ResponseUtilisateurDTO updateUtilisateur(CreateUtilisateurDTO createUtilisateurDTO , Long id);
    boolean deleteUtilisateur(Long id);

}