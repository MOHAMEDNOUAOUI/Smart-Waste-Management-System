package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Bins.CreateBinsDTO;
import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  BinsService {

    ResponseBinsDTO createBins(CreateBinsDTO createBinsDTO);
    Page<ResponseBinsDTO> getAllBinss(Pageable pageable);
    ResponseBinsDTO getBinsById(Long id);
    ResponseBinsDTO updateUser(CreateBinsDTO createBinsDTO , Long id);
    boolean deleteBins(Long id);

}