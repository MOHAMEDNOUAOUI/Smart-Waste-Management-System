package com.wora.systemwastemanagement.Controller;

import com.wora.systemwastemanagement.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ResponseClientDTO> createClient(@RequestBody @Valid CreateClientDTO createClientDTO) {
        ResponseClientDTO response = clientService.createClient(createClientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseClientDTO>> getAllClients(Pageable pageable) {
        Page<ResponseClientDTO> response = clientService.getAllClients(pageable);
        if (response.hasContent()) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }



    @GetMapping("/{clientId}")
    public ResponseEntity<ResponseClientDTO> getClientByName(@PathVariable("clientId") Long id){
        ResponseClientDTO response = clientService.getClientById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClientById(@PathVariable("clientId") Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().body("Client deleted successfully");
    }

    @PatchMapping("/{clientId}")
    public ResponseEntity<ResponseClientDTO> updateClient(@RequestBody CreateClientDTO createClientDTO , @PathVariable("clientId") Long id){
        ResponseClientDTO response = clientService.updateClient(createClientDTO , id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
