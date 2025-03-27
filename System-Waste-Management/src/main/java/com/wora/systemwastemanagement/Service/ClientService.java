package com.wora.systemwastemanagement.Service;
import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface  ClientService {

    ResponseClientDTO createClient(CreateClientDTO createClientDTO);
    Page<ResponseClientDTO> getAllClients(Pageable pageable);
    ResponseClientDTO getClientById(Long id);
    ResponseClientDTO updateClient(CreateClientDTO createClientDTO , Long id);
    void deleteClient(Long id);

}