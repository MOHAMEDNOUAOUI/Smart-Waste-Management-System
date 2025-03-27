package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Task.CreateTaskDTO;
import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import com.wora.systemwastemanagement.DTO.Task.UpdateTask;
import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import com.wora.systemwastemanagement.Entity.Task;
import com.wora.systemwastemanagement.Entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toEntity(CreateTaskDTO createTaskDto);
    ResponseTaskDTO toResponse(Task task);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "worker" , ignore = true)
    void updateTask(UpdateTask updateTask , @MappingTarget Task task);
}