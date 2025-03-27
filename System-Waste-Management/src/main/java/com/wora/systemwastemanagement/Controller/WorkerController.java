package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
import com.wora.systemwastemanagement.Service.VehiculeService;
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

import java.util.List;

@RestController
@RequestMapping("/worker")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkerController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<ResponseWorkerDTO> createWorker(@RequestBody @Valid CreateWorkerDTO createWorkerDTO) {
        ResponseWorkerDTO response = workerService.createWorker(createWorkerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseWorkerDTO>> getAllWorkers(Pageable pageable) {
        Page<ResponseWorkerDTO> response = workerService.getAllWorkers(pageable);
        if (response.getTotalElements() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<ResponseWorkerDTO> getWorkerById(@PathVariable("workerId") Long id){
        ResponseWorkerDTO response = workerService.getWorkerById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{workerId}")
    public ResponseEntity<?> deleteWorkerById(@PathVariable("workerId") Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.ok().body("Worker deleted successfully.");
    }


    @PatchMapping("/{workerId}")
    public ResponseEntity<ResponseWorkerDTO> updateWorker(@RequestBody CreateWorkerDTO createWorkerDTO , @PathVariable("workerId") Long id){
        ResponseWorkerDTO response = workerService.updateWorker(createWorkerDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/hire/{clientId}")
    public ResponseEntity<ResponseWorkerDTO> hireWorker(@PathVariable("clientId") Long clientId){
        ResponseWorkerDTO responseWorkerDTO = workerService.hire(clientId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseWorkerDTO);
    }
}
