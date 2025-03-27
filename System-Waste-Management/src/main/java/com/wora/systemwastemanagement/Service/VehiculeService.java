package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Vehicule.CreateVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  VehiculeService {

    ResponseVehiculeDTO createVehicule(CreateVehiculeDTO createVehiculeDTO);
    Page<ResponseVehiculeDTO> getAllVehicules(Pageable pageable);
    ResponseVehiculeDTO getVehiculeById(Long id);
    ResponseVehiculeDTO updateVehicule(CreateVehiculeDTO createVehiculeDTO , Long id);
    boolean deleteVehicule(Long id);
    List<ResponseVehiculeDTO> workerVehicule();
    ResponseVehiculeDTO assignWorkerToVehicule(Long vehiculeId);


}