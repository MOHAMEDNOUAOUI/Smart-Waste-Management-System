package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import com.wora.systemwastemanagement.Entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(CreateClientDTO createClientDto);
    ResponseClientDTO toResponse(Client client);
}