package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Roots.CreateRootsDTO;
import com.wora.systemwastemanagement.DTO.Roots.ResponseRootsDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  RootsService {

    ResponseRootsDTO createRoots(CreateRootsDTO createRootsDTO);
    Page<ResponseRootsDTO> getAllRootss(Pageable pageable);
    ResponseRootsDTO getRootsById(Long id);
    ResponseRootsDTO updateRoots(CreateRootsDTO createRootsDTO , Long id);
    boolean deleteRoots(Long id);
    List<ResponseRootsDTO> getWorkerRootes();

}