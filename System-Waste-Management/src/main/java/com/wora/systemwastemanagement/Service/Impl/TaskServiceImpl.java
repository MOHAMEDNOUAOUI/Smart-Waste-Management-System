package com.wora.systemwastemanagement.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.TaskRepository;
import com.wora.systemwastemanagement.DTO.Task.CreateTaskDTO;
import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.TaskService;
import com.wora.systemwastemanagement.Mapper.TaskMapper;
import com.wora.systemwastemanagement.Entity.Task;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public ResponseTaskDTO createTask(CreateTaskDTO createTaskDTO) {
        Task entity = taskMapper.toEntity(createTaskDTO);
        Task task = taskRepository.save(entity);
        return taskMapper.toResponse(entity);
    }

    @Override
    public Page<ResponseTaskDTO> getAllTasks(Pageable pageable) {
        Page<Task> tasks = taskRepository.findAll(pageable);
        if (tasks.isEmpty()){
            throw new RuntimeException("The are no tasks yet");
        }
        return tasks.map(taskMapper::toResponse);
    }

    @Override
    public ResponseTaskDTO getTaskById(Long id) {
        if(taskRepository.existsById(id)){
            Task task = taskRepository.findById(id).get();
            return taskMapper.toResponse(task);
        }else{
            throw new EntityNotFoundException("This Task with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()){
            taskRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Task not found");
        }
    }

     @Override
    public ResponseTaskDTO updateTask(CreateTaskDTO createTaskDTO , Long id) {
        return null;
    }
}