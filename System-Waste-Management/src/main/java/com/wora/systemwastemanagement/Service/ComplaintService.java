package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Complaint.CreateComplaintDTO;
import com.wora.systemwastemanagement.DTO.Complaint.ResponseComplaintDTO;

import com.wora.systemwastemanagement.DTO.Task.ResponseTaskDTO;
import com.wora.systemwastemanagement.Entity.Enum.StatutComplaint;
import com.wora.systemwastemanagement.Entity.Enum.TaskStatut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
public interface  ComplaintService {

    ResponseComplaintDTO createComplaint(CreateComplaintDTO createComplaintDTO);
    Page<ResponseComplaintDTO> getAllComplaints(Pageable pageable);
    ResponseComplaintDTO getComplaintById(Long id);
    ResponseComplaintDTO updateComplaint(CreateComplaintDTO createComplaintDTO , Long id);
    boolean deleteComplaint(Long id);
    List<ResponseComplaintDTO> getAllEmployeComplaitns();
    ResponseComplaintDTO updateStatut(StatutComplaint statut, Long id);
    List<ResponseComplaintDTO> getAllUserComplaints();
    List<ResponseComplaintDTO> getALlIntime(LocalDateTime date);
}