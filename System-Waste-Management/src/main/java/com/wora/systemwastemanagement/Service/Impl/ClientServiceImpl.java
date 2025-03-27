package com.wora.systemwastemanagement.Service.Impl;
import com.wora.systemwastemanagement.Entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import com.wora.systemwastemanagement.Repository.ClientRepository;
import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import org.springframework.stereotype.Service;
import com.wora.systemwastemanagement.Service.ClientService;
import com.wora.systemwastemanagement.Mapper.ClientMapper;
import com.wora.systemwastemanagement.Entity.Client;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ResponseClientDTO createClient(CreateClientDTO createClientDTO) {
        Client entity = clientMapper.toEntity(createClientDTO);
        Client client = clientRepository.save(entity);
        return clientMapper.toResponse(client);
    }

    @Override
    public Page<ResponseClientDTO> getAllClients(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        if (clients.isEmpty()){
            throw new RuntimeException("The are no clients yet");
        }
        return clients.map(clientMapper::toResponse);
    }

    @Override
    public ResponseClientDTO getClientById(Long id) {
        if(clientRepository.existsById(id)){
            Client client = clientRepository.findById(id).get();
            return clientMapper.toResponse(client);
        }else{
            throw new EntityNotFoundException("This Client with the id " + id + " doesn not exist");
        }
    }



    @Override
    public void deleteClient(Long id) {
       if(!clientRepository.existsById(id)){
           throw new EntityNotFoundException("This Client with the id " + id + " doesn not exist");
       }
       clientRepository.deleteById(id);
    }

     @Override
    public ResponseClientDTO updateClient(CreateClientDTO createClientDTO , Long id) {
         Client client = clientRepository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + id));
         clientMapper.updateClient(createClientDTO , client);
         Client updatedWorker = clientRepository.save(client);
         return clientMapper.toResponse(updatedWorker);
    }
}