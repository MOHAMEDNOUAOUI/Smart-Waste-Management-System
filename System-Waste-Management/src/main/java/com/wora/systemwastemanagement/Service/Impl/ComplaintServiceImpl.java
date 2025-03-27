package com.wora.systemwastemanagement.Service.Impl;
import com.wora.systemwastemanagement.Entity.Bins;
import com.wora.systemwastemanagement.Entity.Client;
import com.wora.systemwastemanagement.Entity.Enum.StatutComplaint;
import com.wora.systemwastemanagement.Entity.Worker;
import com.wora.systemwastemanagement.Repository.BinsRepository;
import com.wora.systemwastemanagement.Repository.ClientRepository;
import com.wora.systemwastemanagement.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.ComplaintRepository;
import com.wora.systemwastemanagement.DTO.Complaint.CreateComplaintDTO;
import com.wora.systemwastemanagement.DTO.Complaint.ResponseComplaintDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.ComplaintService;
import com.wora.systemwastemanagement.Mapper.ComplaintMapper;
import com.wora.systemwastemanagement.Entity.Complaint;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BinsRepository binsRepository;

    @Override
    public ResponseComplaintDTO createComplaint(CreateComplaintDTO createComplaintDTO) {
        Complaint entity = complaintMapper.toEntity(createComplaintDTO);
        entity.setCreated_at(LocalDateTime.now());
        entity.setStatus(StatutComplaint.PENDING);
        Client client = clientRepository.findById(createComplaintDTO.getClient_id()).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        Bins bin = binsRepository.findById(createComplaintDTO.getBin()).orElseThrow(() -> new EntityNotFoundException("Bins not found"));
        entity.setBins(bin);
        entity.setClient(client);
        entity.setResolved_at(LocalDateTime.now());
        return complaintMapper.toResponse(complaintRepository.save(entity));
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
    public List<ResponseComplaintDTO> getALlIntime(LocalDateTime date) {
        List<Complaint> complaints = complaintRepository.findAll();
        return complaints.stream().filter(complaint -> complaint.getCreated_at() == date).map(complaintMapper::toResponse).toList();
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
    public List<ResponseComplaintDTO> getAllEmployeComplaitns() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null){
            throw new EntityNotFoundException("User not found");
        }
        String email = auth.getName();
        Worker worker = workerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Worker not found"));
        return complaintRepository.findAllByBins_Route_Vehicule_AssignedWorker(worker).stream().map(complaintMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<ResponseComplaintDTO> getAllUserComplaints() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getPrincipal() == null){
            throw new EntityNotFoundException("User not found");
        }
        String email = auth.getName();
        Client client = clientRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return complaintRepository.findAllByClient_Id(client.getId()).stream().map(complaintMapper::toResponse).toList();
    }

    @Override
    public ResponseComplaintDTO updateStatut(StatutComplaint statut, Long id) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found"));
        complaint.setStatus(statut);
        return complaintMapper.toResponse(complaintRepository.save(complaint));
    }

    @Override
    public ResponseComplaintDTO updateComplaint(CreateComplaintDTO createComplaintDTO , Long id) {
        return null;
    }
}