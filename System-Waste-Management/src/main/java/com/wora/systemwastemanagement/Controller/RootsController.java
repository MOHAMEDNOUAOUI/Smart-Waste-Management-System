package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.Service.RootsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Roots.ResponseRootsDTO;
import com.wora.systemwastemanagement.DTO.Roots.CreateRootsDTO;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/roots")
@CrossOrigin(origins = "http://localhost:4200")
public class RootsController {

    @Autowired
    private RootsService rootsService;

    @PostMapping
    public ResponseEntity<ResponseRootsDTO> createRoots(@RequestBody @Valid CreateRootsDTO createRootsDTO) {
        ResponseRootsDTO response = rootsService.createRoots(createRootsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseRootsDTO>> getAllRootss(Pageable pageable) {
        Page<ResponseRootsDTO> response = rootsService.getAllRootss(pageable);
        if (response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{rootsId}")
    public ResponseEntity<ResponseRootsDTO> getRootsById(@PathVariable("rootsId") Long id){
        ResponseRootsDTO response = rootsService.getRootsById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{rootsId}")
    public ResponseEntity<?> deleteRootsById(@PathVariable("rootsId") Long id){
        if(rootsService.deleteRoots(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{rootsId}")
    public ResponseEntity<ResponseRootsDTO> updateRoots(@RequestBody CreateRootsDTO createRootsDTO , @PathVariable("rootsId") Long id){
        ResponseRootsDTO response = rootsService.updateRoots(createRootsDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/workerRoutes")
    public ResponseEntity<List<ResponseRootsDTO>> getRootsRoutes(){
        List<ResponseRootsDTO> responseRootsDTOS = rootsService.getWorkerRootes();
        if (responseRootsDTOS != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseRootsDTOS);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
