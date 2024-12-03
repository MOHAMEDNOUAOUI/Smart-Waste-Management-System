package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import com.wora.systemwastemanagement.DTO.Worker.ResponseWorkerDTO;
import com.wora.systemwastemanagement.Entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    Worker toEntity(CreateWorkerDTO createWorkerDto);
    ResponseWorkerDTO toResponse(Worker worker);
}