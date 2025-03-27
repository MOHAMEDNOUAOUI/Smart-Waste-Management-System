package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import com.wora.systemwastemanagement.Service.VehiculeService;
import com.wora.systemwastemanagement.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.CreateVehiculeDTO;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<ResponseVehiculeDTO> createVehicule(@RequestBody @Valid CreateVehiculeDTO createVehiculeDTO) {
        ResponseVehiculeDTO response = vehiculeService.createVehicule(createVehiculeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseVehiculeDTO>> getAllVehicules(Pageable pageable) {
        Page<ResponseVehiculeDTO> response = vehiculeService.getAllVehicules(pageable);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{vehiculeId}")
    public ResponseEntity<ResponseVehiculeDTO> getVehiculeById(@PathVariable("vehiculeId") Long id){
        ResponseVehiculeDTO response = vehiculeService.getVehiculeById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{vehiculeId}")
    public ResponseEntity<?> deleteVehiculeById(@PathVariable("vehiculeId") Long id){
        if(vehiculeService.deleteVehicule(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{vehiculeId}")
    public ResponseEntity<ResponseVehiculeDTO> updateVehicule(@RequestBody CreateVehiculeDTO createVehiculeDTO , @PathVariable("vehiculeId") Long id){
        ResponseVehiculeDTO response = vehiculeService.updateVehicule(createVehiculeDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/workervehicules")
    public ResponseEntity<List<ResponseVehiculeDTO>> getWorkerVehicules(Pageable pageable){
        List<ResponseVehiculeDTO> responseVehiculeDTOS = vehiculeService.workerVehicule();
        return ResponseEntity.status(HttpStatus.FOUND).body(responseVehiculeDTOS);
    }

    @PutMapping("/assignVehicule/{vehiculeId}")
    public ResponseEntity<ResponseVehiculeDTO> assignWorkerToVehicule(
            @PathVariable Long vehiculeId) {
        ResponseVehiculeDTO updatedVehicule = vehiculeService.assignWorkerToVehicule(vehiculeId);
        return ResponseEntity.ok(updatedVehicule);
    }

}
