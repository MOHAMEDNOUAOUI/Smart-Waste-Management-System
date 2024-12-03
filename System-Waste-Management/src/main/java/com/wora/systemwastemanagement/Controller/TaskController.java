package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import com.wora.systemwastemanagement.DTO.Task.CreateTaskDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<ResponseTaskDTO> createTask(@RequestBody @Valid CreateTaskDTO createTaskDTO) {
        ResponseTaskDTO response = taskService.createTask(createTaskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseTaskDTO>> getAllTasks(Pageable pageable) {
        Page<ResponseTaskDTO> response = taskService.getAllTasks(pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ResponseTaskDTO> getTaskById(@PathVariable("taskId") Long id){
        ResponseTaskDTO response = taskService.getTaskById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTaskById(@PathVariable("taskId") Long id){
        if(taskService.deleteTask(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<ResponseTaskDTO> updateTask(@RequestBody CreateTaskDTO createTaskDTO , @PathVariable("taskId") Long id){
        ResponseTaskDTO response = taskService.updateTask(createTaskDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
