package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import com.wora.systemwastemanagement.DTO.Worker.ResponseWorkerDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  WorkerService {

    ResponseWorkerDTO createWorker(CreateWorkerDTO createWorkerDTO);
    Page<ResponseWorkerDTO> getAllWorkers(Pageable pageable);
    ResponseWorkerDTO getWorkerById(Long id);
    ResponseWorkerDTO updateWorker(CreateWorkerDTO createWorkerDTO , Long id);
    boolean deleteWorker(Long id);

}