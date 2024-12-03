package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Bins.CreateBinsDTO;
import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;
import com.wora.systemwastemanagement.Entity.Bins;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BinsMapper {

    Bins toEntity(CreateBinsDTO createBinsDto);
    ResponseBinsDTO toResponse(Bins bins);
}