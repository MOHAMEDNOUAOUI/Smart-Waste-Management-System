package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Vehicule.CreateVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
import com.wora.systemwastemanagement.Entity.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    Vehicule toEntity(CreateVehiculeDTO createVehiculeDto);
    @Mapping(source = "routes" , target = "routes")
    ResponseVehiculeDTO toResponse(Vehicule vehicule);
}