package com.wora.systemwastemanagement.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.ComplaintRepository;
import com.wora.systemwastemanagement.DTO.Complaint.CreateComplaintDTO;
import com.wora.systemwastemanagement.DTO.Complaint.ResponseComplaintDTO;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.ComplaintService;
import com.wora.systemwastemanagement.Mapper.ComplaintMapper;
import com.wora.systemwastemanagement.Entity.Complaint;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public ResponseComplaintDTO createComplaint(CreateComplaintDTO createComplaintDTO) {
        Complaint entity = complaintMapper.toEntity(createComplaintDTO);
        Complaint complaint = complaintRepository.save(entity);
        return complaintMapper.toResponse(entity);
    }

    @Override
    public Page<ResponseComplaintDTO> getAllComplaints(Pageable pageable) {
        Page<Complaint> complaints = complaintRepository.findAll(pageable);
        if (complaints.isEmpty()){
            throw new RuntimeException("The are no complaints yet");
        }
        return complaints.map(complaintMapper::toResponse);
    }

    @Override
    public ResponseComplaintDTO getComplaintById(Long id) {
        if(complaintRepository.existsById(id)){
            Complaint complaint = complaintRepository.findById(id).get();
            return complaintMapper.toResponse(complaint);
        }else{
            throw new EntityNotFoundException("This Complaint with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteComplaint(Long id) {
        Optional<Complaint> complaint = complaintRepository.findById(id);
        if (complaint.isPresent()){
            complaintRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Complaint not found");
        }
    }

     @Override
    public ResponseComplaintDTO updateComplaint(CreateComplaintDTO createComplaintDTO , Long id) {
        return null;
    }
}