package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import com.wora.systemwastemanagement.Entity.Enum.StatutComplaint;
import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
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

import java.time.LocalDateTime;
import java.util.List;

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
        if (response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
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

    @GetMapping("/workerComplaints")
    public ResponseEntity<List<ResponseComplaintDTO>> getEmployeeComplaints() {
        List<ResponseComplaintDTO> responseComplaintDTOS = complaintService.getAllEmployeComplaitns();
        if (responseComplaintDTOS != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseComplaintDTOS);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/MyComplaints")
    public ResponseEntity<List<ResponseComplaintDTO>> getMyComplaints() {
        List<ResponseComplaintDTO> responseComplaintDTOS = complaintService.getAllUserComplaints();
        if (responseComplaintDTOS != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseComplaintDTOS);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/updateStatut/{statut}/{id}")
    public ResponseEntity<ResponseComplaintDTO> updateTaskStatus(@PathVariable("statut") StatutComplaint statut, @PathVariable("id") Long id){
        ResponseComplaintDTO responseComplaintDTO = complaintService.updateStatut(statut,id);
        if (responseComplaintDTO!=null){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseComplaintDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseComplaintDTO);
    }


    @GetMapping("/InTime/{time}")
    public ResponseEntity<List<ResponseComplaintDTO>> getAllInTime(@PathVariable("time")LocalDateTime date){
        List<ResponseComplaintDTO> response = complaintService.getALlIntime(date);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
