package com.wora.systemwastemanagement.Service.Impl;
import com.wora.systemwastemanagement.Entity.Bins;
import com.wora.systemwastemanagement.Entity.Vehicule;
import com.wora.systemwastemanagement.Mapper.BinsMapper;
import com.wora.systemwastemanagement.Repository.BinsRepository;
import com.wora.systemwastemanagement.Repository.VehiculeRepository;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.RootsRepository;
import com.wora.systemwastemanagement.DTO.Roots.CreateRootsDTO;
import com.wora.systemwastemanagement.DTO.Roots.ResponseRootsDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.RootsService;
import com.wora.systemwastemanagement.Mapper.RootsMapper;
import com.wora.systemwastemanagement.Entity.Roots;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RootsServiceImpl implements RootsService {

    @Autowired
    private RootsRepository rootsRepository;
    @Autowired
    private BinsRepository binsRepository;

    @Autowired
    private RootsMapper rootsMapper;
    @Autowired
    private BinsMapper binsMapper;
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public ResponseRootsDTO createRoots(CreateRootsDTO createRootsDTO) {
        Roots root = rootsMapper.toEntity(createRootsDTO);
        Vehicule vehicule = vehiculeRepository.findById(createRootsDTO.getVehiculeId()).orElseThrow(() -> new EntityNotFoundException("Vehicule not found"));
        root.setVehicule(vehicule);
        root = rootsRepository.save(root);

        Roots finalRoot = root;
        List<Bins> bins = createRootsDTO.getBins().stream()
                .map(bin -> {
                    Bins entity = binsMapper.toEntity(bin);
                    entity.setLast_maintenance(LocalDateTime.now());
                    entity.setRoute(finalRoot);
                    return binsRepository.save(entity);
                })
                .collect(Collectors.toList());

        root.setBins(bins);
        return rootsMapper.toResponse(root);
    }



    @Override
    public Page<ResponseRootsDTO> getAllRootss(Pageable pageable) {
        Page<Roots> rootss = rootsRepository.findAll(pageable);
        if (rootss.isEmpty()){
            throw new RuntimeException("The are no rootss yet");
        }
        return rootss.map(rootsMapper::toResponse);
    }

    @Override
    public ResponseRootsDTO getRootsById(Long id) {
        if(rootsRepository.existsById(id)){
            Roots roots = rootsRepository.findById(id).get();
            return rootsMapper.toResponse(roots);
        }else{
            throw new EntityNotFoundException("This Roots with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteRoots(Long id) {
        Optional<Roots> roots = rootsRepository.findById(id);
        if (roots.isPresent()){
            rootsRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Roots not found");
        }
    }

    @Override
    public List<ResponseRootsDTO> getWorkerRootes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            throw new RuntimeException ("No authentication found");
        }

        String email = authentication.getName();
        List<Roots> rootss = rootsRepository.findAllByVehicule_AssignedWorker_Email(email);
        if (rootss.isEmpty()){
            throw new RuntimeException("The are no rootss yet");
        }
        return rootss.stream().map(rootsMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ResponseRootsDTO updateRoots(CreateRootsDTO createRootsDTO , Long id) {
        return null;
    }
}