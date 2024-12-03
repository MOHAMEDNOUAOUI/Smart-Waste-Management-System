package com.wora.systemwastemanagement.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.RootsRepository;
import com.wora.systemwastemanagement.DTO.Roots.CreateRootsDTO;
import com.wora.systemwastemanagement.DTO.Roots.ResponseRootsDTO;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.RootsService;
import com.wora.systemwastemanagement.Mapper.RootsMapper;
import com.wora.systemwastemanagement.Entity.Roots;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class RootsServiceImpl implements RootsService {

    @Autowired
    private RootsRepository rootsRepository;

    @Autowired
    private RootsMapper rootsMapper;

    @Override
    public ResponseRootsDTO createRoots(CreateRootsDTO createRootsDTO) {
        Roots entity = rootsMapper.toEntity(createRootsDTO);
        Roots roots = rootsRepository.save(entity);
        return rootsMapper.toResponse(entity);
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
    public ResponseRootsDTO updateRoots(CreateRootsDTO createRootsDTO , Long id) {
        return null;
    }
}