package com.wora.systemwastemanagement.Service.Impl;
import com.wora.systemwastemanagement.DTO.Task.UpdateTask;
import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
import com.wora.systemwastemanagement.Entity.Worker;
import com.wora.systemwastemanagement.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.TaskRepository;
import com.wora.systemwastemanagement.DTO.Task.CreateTaskDTO;
import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public ResponseTaskDTO createTask(CreateTaskDTO createTaskDTO) {
        Worker worker = workerRepository.findById(createTaskDTO.getWorkerId())
                .orElseThrow(EntityNotFoundException::new);

        Task entity = taskMapper.toEntity(createTaskDTO);
        entity.setWorker(worker);
        Task task = taskRepository.save(entity);
        return taskMapper.toResponse(task);
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
    public List<ResponseTaskDTO> workerTask() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null){
            throw new EntityNotFoundException("User not found");
        }
        String email = auth.getName();
        Worker worker = workerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Worker not found"));
        return worker.getTaskList().stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    @Override
    public ResponseTaskDTO updateStatut(TaskStatut statut, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        task.setTaskStatus(statut);
        Task updatedTask = taskRepository.save(task);
        return taskMapper.toResponse(updatedTask);
    }

    @Override
    public ResponseTaskDTO updateTask(UpdateTask updateTask) {
        Task task = taskRepository.findById(updateTask.getId())
                .orElseThrow(EntityNotFoundException::new);
        taskMapper.updateTask(updateTask , task);
        Task updatedTask = taskRepository.save(task);
        System.out.println(updatedTask);
        return taskMapper.toResponse(updatedTask);
    }
}