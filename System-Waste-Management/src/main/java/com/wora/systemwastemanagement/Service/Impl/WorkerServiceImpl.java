package com.wora.systemwastemanagement.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.WorkerRepository;
import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import com.wora.systemwastemanagement.DTO.Worker.ResponseWorkerDTO;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.WorkerService;
import com.wora.systemwastemanagement.Mapper.WorkerMapper;
import com.wora.systemwastemanagement.Entity.Worker;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public ResponseWorkerDTO createWorker(CreateWorkerDTO createWorkerDTO) {
        Worker entity = workerMapper.toEntity(createWorkerDTO);
        Worker worker = workerRepository.save(entity);
        return workerMapper.toResponse(entity);
    }

    @Override
    public Page<ResponseWorkerDTO> getAllWorkers(Pageable pageable) {
        Page<Worker> workers = workerRepository.findAll(pageable);
        if (workers.isEmpty()){
            throw new RuntimeException("The are no workers yet");
        }
        return workers.map(workerMapper::toResponse);
    }

    @Override
    public ResponseWorkerDTO getWorkerById(Long id) {
        if(workerRepository.existsById(id)){
            Worker worker = workerRepository.findById(id).get();
            return workerMapper.toResponse(worker);
        }else{
            throw new EntityNotFoundException("This Worker with the id " + id + " doesn not exist");
        }
    }


    @Override
    public boolean deleteWorker(Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isPresent()){
            workerRepository.deleteById(id);
            return true;
        }
        else {
            throw new EntityNotFoundException("Worker not found");
        }
    }

     @Override
    public ResponseWorkerDTO updateWorker(CreateWorkerDTO createWorkerDTO , Long id) {
        return null;
    }
}