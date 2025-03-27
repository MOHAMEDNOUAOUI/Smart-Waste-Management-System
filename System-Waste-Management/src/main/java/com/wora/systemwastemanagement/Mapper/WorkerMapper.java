package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import com.wora.systemwastemanagement.DTO.Worker.ResponseWorkerDTO;
import com.wora.systemwastemanagement.Entity.Worker;
import org.hibernate.jdbc.Work;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WorkerMapper {
    Worker toEntity(CreateWorkerDTO createWorkerDto);
    ResponseWorkerDTO toResponse(Worker worker);

    @Mapping(target = "id" , ignore = true)
    void updateWorker(CreateWorkerDTO dto , @MappingTarget Worker worker);
}