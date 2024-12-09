package com.wora.apidegestiondescoupesdefootball.Mapper;

import com.wora.apidegestiondescoupesdefootball.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.apidegestiondescoupesdefootball.DTO.Utilisateur.ResponseUtilisateurDTO;
import com.wora.apidegestiondescoupesdefootball.Entity.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    Utilisateur toEntity(CreateUtilisateurDTO createUtilisateurDto);
    ResponseUtilisateurDTO toResponse(Utilisateur utilisateur);
}