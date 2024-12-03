package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Complaint.CreateComplaintDTO;
import com.wora.systemwastemanagement.DTO.Complaint.ResponseComplaintDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  ComplaintService {

    ResponseComplaintDTO createComplaint(CreateComplaintDTO createComplaintDTO);
    Page<ResponseComplaintDTO> getAllComplaints(Pageable pageable);
    ResponseComplaintDTO getComplaintById(Long id);
    ResponseComplaintDTO updateUser(CreateComplaintDTO createComplaintDTO , Long id);
    boolean deleteComplaint(Long id);

}