package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Worker.ResponseWorkerDTO;
import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping
    public ResponseEntity<ResponseWorkerDTO> createWorker(@RequestBody @Valid CreateWorkerDTO createWorkerDTO) {
        ResponseWorkerDTO response = workerService.createWorker(createWorkerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseWorkerDTO>> getAllWorkers(Pageable pageable) {
        Page<ResponseWorkerDTO> response = workerService.getAllWorkers(pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<ResponseWorkerDTO> getWorkerById(@PathVariable("workerId") Long id){
        ResponseWorkerDTO response = workerService.getWorkerById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{workerId}")
    public ResponseEntity<?> deleteWorkerById(@PathVariable("workerId") Long id){
        if(workerService.deleteWorker(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{workerId}")
    public ResponseEntity<ResponseWorkerDTO> updateWorker(@RequestBody CreateWorkerDTO createWorkerDTO , @PathVariable("workerId") Long id){
        ResponseWorkerDTO response = workerService.updateWorker(createWorkerDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
