package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.DTO.Task.UpdateTask;
import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
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

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ResponseTaskDTO> getTaskById(@PathVariable("taskId") Long id){
        ResponseTaskDTO response = taskService.getTaskById(id);
        if (response==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTaskById(@PathVariable("taskId") Long id){
        if(taskService.deleteTask(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PutMapping()
    public ResponseEntity<ResponseTaskDTO> updateTask(@RequestBody UpdateTask updateTask){
        ResponseTaskDTO response = taskService.updateTask(updateTask);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/updateStatut/{statut}/{id}")
    public ResponseEntity<ResponseTaskDTO> updateTaskStatus(@PathVariable("statut") TaskStatut statut, @PathVariable("id") Long id){
        ResponseTaskDTO responseTaskDTO = taskService.updateStatut(statut,id);
        if (responseTaskDTO!=null){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseTaskDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseTaskDTO);
    }

    @GetMapping("/workerTasks")
    public ResponseEntity<List<ResponseTaskDTO>> getWorkerTasks(Pageable pageable){
        List<ResponseTaskDTO> responseTaskDTOS = taskService.workerTask();
        if (responseTaskDTOS != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseTaskDTOS);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseTaskDTOS);
    }


}
