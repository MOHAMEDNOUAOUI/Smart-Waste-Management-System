package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.Service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.CreateVehiculeDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicule")
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
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
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

}
