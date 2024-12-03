package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Complaint.ResponseComplaintDTO;
import com.wora.systemwastemanagement.DTO.Complaint.CreateComplaintDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<ResponseComplaintDTO> createComplaint(@RequestBody @Valid CreateComplaintDTO createComplaintDTO) {
        ResponseComplaintDTO response = complaintService.createComplaint(createComplaintDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseComplaintDTO>> getAllComplaints(Pageable pageable) {
        Page<ResponseComplaintDTO> response = complaintService.getAllComplaints(pageable);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{complaintId}")
    public ResponseEntity<ResponseComplaintDTO> getComplaintById(@PathVariable("complaintId") Long id){
        ResponseComplaintDTO response = complaintService.getComplaintById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{complaintId}")
    public ResponseEntity<?> deleteComplaintById(@PathVariable("complaintId") Long id){
        if(complaintService.deleteComplaint(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted Succefully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
    }

    @PatchMapping("/{complaintId}")
    public ResponseEntity<ResponseComplaintDTO> updateComplaint(@RequestBody CreateComplaintDTO createComplaintDTO , @PathVariable("complaintId") Long id){
        ResponseComplaintDTO response = complaintService.updateComplaint(createComplaintDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
