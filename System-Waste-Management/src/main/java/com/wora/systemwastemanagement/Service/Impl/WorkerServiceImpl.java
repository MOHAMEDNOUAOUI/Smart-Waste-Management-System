package com.wora.systemwastemanagement.Service.Impl;
import com.wora.systemwastemanagement.Entity.Client;
import com.wora.systemwastemanagement.Entity.Enum.Rrole;
import com.wora.systemwastemanagement.Repository.ClientRepository;
import jakarta.transaction.Transactional;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerMapper workerMapper;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ResponseWorkerDTO createWorker(CreateWorkerDTO createWorkerDTO) {
        Worker entity = workerMapper.toEntity(createWorkerDTO);
        Worker worker = workerRepository.save(entity);
        return workerMapper.toResponse(worker);
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
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("This Worker with the id " + id + " does not exist"));

        return workerMapper.toResponse(worker);
    }



    @Override
    public void deleteWorker(Long id) {
        if (!workerRepository.existsById(id)) {
            throw new EntityNotFoundException("Worker not found");
        }
        workerRepository.deleteById(id);
    }

    @Override
    public ResponseWorkerDTO hire(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        Worker worker = new Worker();
        worker.setHire_date(LocalDateTime.now());
        worker.setSalaire(2000.0);
        worker.setJob_title("worker");
        worker.setContact_info("N/A");
        worker.setRrole(Rrole.ROLE_WORKER);
        Worker Saved = workerRepository.save(worker);
        workerRepository.flush();
        clientRepository.deleteById(client.getId());
        return workerMapper.toResponse(Saved);
    }


    @Override
    public ResponseWorkerDTO updateWorker(CreateWorkerDTO createWorkerDTO , Long id) {
         Worker worker = workerRepository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Worker not found with id " + id));
         workerMapper.updateWorker(createWorkerDTO , worker);
        Worker updatedWorker = workerRepository.save(worker);
        return workerMapper.toResponse(updatedWorker);
    }
}