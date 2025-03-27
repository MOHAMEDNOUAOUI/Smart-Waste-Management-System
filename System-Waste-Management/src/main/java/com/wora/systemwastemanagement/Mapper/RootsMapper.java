package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Roots.CreateRootsDTO;
import com.wora.systemwastemanagement.DTO.Roots.ResponseRootsDTO;
import com.wora.systemwastemanagement.Entity.Roots;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RootsMapper {
    @Mapping(target = "bins" , ignore = true)
    Roots toEntity(CreateRootsDTO createRootsDto);
    ResponseRootsDTO toResponse(Roots roots);
}