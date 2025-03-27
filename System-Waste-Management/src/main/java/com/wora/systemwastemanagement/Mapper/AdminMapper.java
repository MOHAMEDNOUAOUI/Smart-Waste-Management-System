package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import com.wora.systemwastemanagement.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.systemwastemanagement.DTO.Utilisateur.ResponseUtilisateurDTO;
import com.wora.systemwastemanagement.Entity.Admin;
import com.wora.systemwastemanagement.Entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(CreateUtilisateurDTO createUtilisateurDTO);
    ResponseUtilisateurDTO toResponse(Admin admin);

    @Mapping(target = "id" , ignore = true)
    void updateAdmin(CreateUtilisateurDTO dto , @MappingTarget Admin admin);
}
