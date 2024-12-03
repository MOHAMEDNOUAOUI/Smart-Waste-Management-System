package com.wora.systemwastemanagement.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.VehiculeRepository;
import com.wora.systemwastemanagement.DTO.Vehicule.CreateVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
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

    @Override
    public ResponseVehiculeDTO createVehicule(CreateVehiculeDTO createVehiculeDTO) {
        Vehicule entity = vehiculeMapper.toEntity(createVehiculeDTO);
        Vehicule vehicule = vehiculeRepository.save(entity);
        return vehiculeMapper.toResponse(entity);
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
    public ResponseVehiculeDTO updateVehicule(CreateVehiculeDTO createVehiculeDTO , Long id) {
        return null;
    }
}