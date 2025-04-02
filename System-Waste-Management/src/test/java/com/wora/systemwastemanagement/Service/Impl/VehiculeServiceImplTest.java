package com.wora.systemwastemanagement.Service.Impl;

import com.wora.systemwastemanagement.DTO.Vehicule.CreateVehiculeDTO;
import com.wora.systemwastemanagement.DTO.Vehicule.ResponseVehiculeDTO;
import com.wora.systemwastemanagement.Entity.Vehicule;
import com.wora.systemwastemanagement.Entity.Worker;
import com.wora.systemwastemanagement.Mapper.VehiculeMapper;
import com.wora.systemwastemanagement.Repository.VehiculeRepository;
import com.wora.systemwastemanagement.Repository.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehiculeServiceImplTest {

    @Mock
    private VehiculeRepository vehiculeRepository;

    @Mock
    private VehiculeMapper vehiculeMapper;

    @Mock
    private WorkerRepository workerRepository;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    @InjectMocks
    private VehiculeServiceImpl vehiculeService;

    private Vehicule vehicule;
    private Worker worker;
    private CreateVehiculeDTO createVehiculeDTO;
    private ResponseVehiculeDTO responseVehiculeDTO;

    @BeforeEach
    void setUp() {
        vehicule = new Vehicule();
        vehicule.setId(1L);
        
        worker = new Worker();
        worker.setId(1L);
        worker.setEmail("worker@example.com");
        
        createVehiculeDTO = new CreateVehiculeDTO();
        createVehiculeDTO.setWorker_id(1L);
        
        responseVehiculeDTO = new ResponseVehiculeDTO();
        
        // Setup SecurityContext mock
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void createVehicule_Success() {
        when(workerRepository.findById(1L)).thenReturn(Optional.of(worker));
        when(vehiculeMapper.toEntity(any())).thenReturn(vehicule);
        when(vehiculeRepository.save(any())).thenReturn(vehicule);
        when(vehiculeMapper.toResponse(any())).thenReturn(responseVehiculeDTO);

        ResponseVehiculeDTO result = vehiculeService.createVehicule(createVehiculeDTO);

        assertNotNull(result);
        verify(workerRepository).findById(1L);
        verify(vehiculeRepository).save(any());
    }

    @Test
    void createVehicule_WorkerNotFound() {
        when(workerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> 
            vehiculeService.createVehicule(createVehiculeDTO)
        );
    }

    @Test
    void getAllVehicules_Success() {
        Page<Vehicule> vehiculePage = new PageImpl<>(Arrays.asList(vehicule));
        when(vehiculeRepository.findAll(any(PageRequest.class))).thenReturn(vehiculePage);
        when(vehiculeMapper.toResponse(any())).thenReturn(responseVehiculeDTO);

        Page<ResponseVehiculeDTO> result = vehiculeService.getAllVehicules(PageRequest.of(0, 10));

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
    }

    @Test
    void getAllVehicules_Empty() {
        Page<Vehicule> emptyPage = new PageImpl<>(List.of());
        when(vehiculeRepository.findAll(any(PageRequest.class))).thenReturn(emptyPage);

        assertThrows(RuntimeException.class, () ->
            vehiculeService.getAllVehicules(PageRequest.of(0, 10))
        );
    }

    @Test
    void getVehiculeById_Success() {
        when(vehiculeRepository.existsById(1L)).thenReturn(true);
        when(vehiculeRepository.findById(1L)).thenReturn(Optional.of(vehicule));
        when(vehiculeMapper.toResponse(any())).thenReturn(responseVehiculeDTO);

        ResponseVehiculeDTO result = vehiculeService.getVehiculeById(1L);

        assertNotNull(result);
        verify(vehiculeRepository).existsById(1L);
    }

    @Test
    void getVehiculeById_NotFound() {
        when(vehiculeRepository.existsById(1L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () ->
            vehiculeService.getVehiculeById(1L)
        );
    }

    @Test
    void deleteVehicule_Success() {
        when(vehiculeRepository.findById(1L)).thenReturn(Optional.of(vehicule));

        boolean result = vehiculeService.deleteVehicule(1L);

        assertTrue(result);
        verify(vehiculeRepository).deleteById(1L);
    }

    @Test
    void deleteVehicule_NotFound() {
        when(vehiculeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
            vehiculeService.deleteVehicule(1L)
        );
    }



} 