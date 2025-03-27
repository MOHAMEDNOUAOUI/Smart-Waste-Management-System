package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.Service.BinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;
import com.wora.systemwastemanagement.DTO.Bins.CreateBinsDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bins")
@CrossOrigin(origins = "http://localhost:4200")
public class BinsController {

    @Autowired
    private BinsService binsService;

    @PostMapping
    public ResponseEntity<ResponseBinsDTO> createBins(@RequestBody @Valid CreateBinsDTO createBinsDTO) {
        ResponseBinsDTO response = binsService.createBins(createBinsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseBinsDTO>> getAllBinss(Pageable pageable) {
        Page<ResponseBinsDTO> response = binsService.getAllBinss(pageable);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{binsId}")
    public ResponseEntity<ResponseBinsDTO> getBinsById(@PathVariable("binsId") Long id){
        ResponseBinsDTO response = binsService.getBinsById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{binsId}")
    public ResponseEntity<?> deleteBinsById(@PathVariable("binsId") Long id){
        if(binsService.deleteBins(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{binsId}")
    public ResponseEntity<ResponseBinsDTO> updateBins(@RequestBody CreateBinsDTO createBinsDTO , @PathVariable("binsId") Long id){
        ResponseBinsDTO response = binsService.updateBins(createBinsDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
