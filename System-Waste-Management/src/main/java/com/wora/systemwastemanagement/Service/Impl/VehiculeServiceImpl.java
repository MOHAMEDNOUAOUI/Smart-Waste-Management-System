package com.wora.systemwastemanagement.Service.Impl;
import com.wora.systemwastemanagement.Entity.Worker;
import com.wora.systemwastemanagement.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.VehiculeRepository;
import com.wora.systemwastemanagement.DTO.Vehicule.CreateVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.VehiculeService;
import com.wora.systemwastemanagement.Mapper.VehiculeMapper;
import com.wora.systemwastemanagement.Entity.Vehicule;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private VehiculeMapper vehiculeMapper;
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public ResponseVehiculeDTO createVehicule(CreateVehiculeDTO createVehiculeDTO) {
        Worker worker = workerRepository.findById(createVehiculeDTO.getWorker_id()).orElseThrow(() -> new EntityNotFoundException("Worker not found"));
        Vehicule entity = vehiculeMapper.toEntity(createVehiculeDTO);
        entity.setAssignedWorker(worker);
        return vehiculeMapper.toResponse(vehiculeRepository.save(entity));
    }

    @Override
    public Page<ResponseVehiculeDTO> getAllVehicules(Pageable pageable) {
        Page<Vehicule> vehicules = vehiculeRepository.findAll(pageable);
        if (vehicules.isEmpty()){
            throw new RuntimeException("The are no vehicules yet");
        }
        return vehicules.map(vehiculeMapper::toResponse);
    }

    @Override
    public ResponseVehiculeDTO getVehiculeById(Long id) {
        if(vehiculeRepository.existsById(id)){
            Vehicule vehicule = vehiculeRepository.findById(id).get();
            return vehiculeMapper.toResponse(vehicule);
        }else{
            throw new EntityNotFoundException("This Vehicule with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteVehicule(Long id) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (vehicule.isPresent()){
            vehiculeRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Vehicule not found");
        }
    }

    @Override
    public List<ResponseVehiculeDTO> workerVehicule() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            throw new RuntimeException ("No authentication found");
        }

        String email = authentication.getName();
        Worker worker = workerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Worker not found"));

        return worker.getVehiculeList().stream()
                .map(vehiculeMapper::toResponse)
                .toList();
    }

    @Override
    public ResponseVehiculeDTO assignWorkerToVehicule(Long vehiculeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            throw new RuntimeException ("No authentication found");
        }
        String email = authentication.getName();

        Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new RuntimeException("Vehicule not found"));

        Worker worker = workerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        vehicule.setAssignedWorker(worker);
        return vehiculeMapper.toResponse(vehiculeRepository.save(vehicule));
    }


    @Override
    public ResponseVehiculeDTO updateVehicule(CreateVehiculeDTO createVehiculeDTO , Long id) {
        return null;
    }
}