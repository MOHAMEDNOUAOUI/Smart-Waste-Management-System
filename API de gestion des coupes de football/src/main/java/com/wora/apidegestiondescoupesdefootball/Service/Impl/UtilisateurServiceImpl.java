package com.wora.apidegestiondescoupesdefootball.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.apidegestiondescoupesdefootball.Repository.UtilisateurRepository;
import com.wora.apidegestiondescoupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.apidegestiondescoupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;
import org.springframework.stereotype.Service;
import com.wora.apidegestiondescoupesdefootball.Service.UtilisateurService;
import com.wora.apidegestiondescoupesdefootball.Mapper.UtilisateurMapper;
import com.wora.apidegestiondescoupesdefootball.Entity.Utilisateur;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Override
    public ResponseUtilisateurDTO createUtilisateur(CreateUtilisateurDTO createUtilisateurDTO) {
        Utilisateur entity = utilisateurMapper.toEntity(createUtilisateurDTO);
        Utilisateur utilisateur = utilisateurRepository.save(entity);
        return utilisateurMapper.toResponse(entity);
    }

    @Override
    public Page<ResponseUtilisateurDTO> getAllUtilisateurs(Pageable pageable) {
        Page<Utilisateur> utilisateurs = utilisateurRepository.findAll(pageable);
        if (utilisateurs.isEmpty()){
            throw new RuntimeException("The are no utilisateurs yet");
        }
        return utilisateurs.map(utilisateurMapper::toResponse);
    }

    @Override
    public ResponseUtilisateurDTO getUtilisateurById(Long id) {
        if(utilisateurRepository.existsById(id)){
            Utilisateur utilisateur = utilisateurRepository.findById(id).get();
            return utilisateurMapper.toResponse(utilisateur);
        }else{
            throw new EntityNotFoundException("This Utilisateur with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteUtilisateur(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()){
            utilisateurRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Utilisateur not found");
        }
    }

     @Override
    public ResponseUtilisateurDTO updateUtilisateur(CreateUtilisateurDTO createUtilisateurDTO , Long id) {
        return null;
    }
}