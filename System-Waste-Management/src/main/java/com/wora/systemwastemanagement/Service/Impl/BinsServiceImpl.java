package com.wora.systemwastemanagement.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.BinsRepository;
import com.wora.systemwastemanagement.DTO.Bins.CreateBinsDTO;
import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.BinsService;
import com.wora.systemwastemanagement.Mapper.BinsMapper;
import com.wora.systemwastemanagement.Entity.Bins;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class BinsServiceImpl implements BinsService {

    @Autowired
    private BinsRepository binsRepository;

    @Autowired
    private BinsMapper binsMapper;

    @Override
    public ResponseBinsDTO createBins(CreateBinsDTO createBinsDTO) {
        Bins entity = binsMapper.toEntity(createBinsDTO);
        Bins bins = binsRepository.save(entity);
        return binsMapper.toResponse(entity);
    }

    @Override
    public Page<ResponseBinsDTO> getAllBinss(Pageable pageable) {
        Page<Bins> binss = binsRepository.findAll(pageable);
        if (binss.isEmpty()){
            throw new RuntimeException("The are no binss yet");
        }
        return binss.map(binsMapper::toResponse);
    }

    @Override
    public ResponseBinsDTO getBinsById(Long id) {
        if(binsRepository.existsById(id)){
            Bins bins = binsRepository.findById(id).get();
            return binsMapper.toResponse(bins);
        }else{
            throw new EntityNotFoundException("This Bins with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteBins(Long id) {
        Optional<Bins> bins = binsRepository.findById(id);
        if (bins.isPresent()){
            binsRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Bins not found");
        }
    }

     @Override
    public ResponseBinsDTO updateBins(CreateBinsDTO createBinsDTO , Long id) {
        return null;
    }
}