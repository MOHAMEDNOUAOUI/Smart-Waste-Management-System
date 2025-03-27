package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import com.wora.systemwastemanagement.Entity.Client;
import com.wora.systemwastemanagement.Entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(CreateClientDTO createClientDto);
    ResponseClientDTO toResponse(Client client);

    @Mapping(target = "id" , ignore = true)
    void updateClient(CreateClientDTO dto , @MappingTarget Client client);
}