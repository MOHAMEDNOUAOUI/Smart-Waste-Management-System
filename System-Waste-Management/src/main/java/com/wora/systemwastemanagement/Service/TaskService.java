package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Task.CreateTaskDTO;
import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;

import com.wora.systemwastemanagement.DTO.Task.UpdateTask;
import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  TaskService {

    ResponseTaskDTO createTask(CreateTaskDTO createTaskDTO);
    Page<ResponseTaskDTO> getAllTasks(Pageable pageable);
    ResponseTaskDTO getTaskById(Long id);
    ResponseTaskDTO updateTask(UpdateTask updateTask);
    boolean deleteTask(Long id);
    List<ResponseTaskDTO> workerTask();
    ResponseTaskDTO updateStatut(TaskStatut statut, Long id);
}