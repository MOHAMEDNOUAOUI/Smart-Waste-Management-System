package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Task.CreateTaskDTO;
import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import com.wora.systemwastemanagement.Entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toEntity(CreateTaskDTO createTaskDto);
    ResponseTaskDTO toResponse(Task task);
}