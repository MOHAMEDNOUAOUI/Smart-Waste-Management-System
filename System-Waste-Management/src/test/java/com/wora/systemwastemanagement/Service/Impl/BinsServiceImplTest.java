package com.wora.systemwastemanagement.Service.Impl;

import com.wora.systemwastemanagement.DTO.Bins.CreateBinsDTO;
import com.wora.systemwastemanagement.DTO.Bins.ResponseBinsDTO;
import com.wora.systemwastemanagement.Entity.Bins;
import com.wora.systemwastemanagement.Mapper.BinsMapper;
import com.wora.systemwastemanagement.Repository.BinsRepository;
import com.wora.systemwastemanagement.Service.BinsService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

class BinsServiceImplTest {
    @Mock
    private BinsRepository binsRepository;
    
    @Mock
    private BinsMapper binsMapper;
    
    @Mock
    private Authentication authentication;
    
    @Mock
    private SecurityContext securityContext;
    
    @InjectMocks
    private BinsServiceImpl binsService;

    private Bins bins;
    private CreateBinsDTO createBinsDTO;
    private ResponseBinsDTO responseBinsDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        bins = new Bins();
        bins.setId(1L);
        
        createBinsDTO = new CreateBinsDTO();
        
        responseBinsDTO = new ResponseBinsDTO();
        
        // Setup SecurityContext mock
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void createBins_Success() {
        when(binsMapper.toEntity(createBinsDTO)).thenReturn(bins);
        when(binsRepository.save(bins)).thenReturn(bins);
        when(binsMapper.toResponse(bins)).thenReturn(responseBinsDTO);

        ResponseBinsDTO result = binsService.createBins(createBinsDTO);

        assertNotNull(result);
        verify(binsRepository).save(bins);
    }

    @Test
    void getAllBinss_Success() {
        Page<Bins> binsPage = new PageImpl<>(Arrays.asList(bins));
        when(binsRepository.findAll(any(PageRequest.class))).thenReturn(binsPage);
        when(binsMapper.toResponse(any())).thenReturn(responseBinsDTO);

        Page<ResponseBinsDTO> result = binsService.getAllBinss(PageRequest.of(0, 10));

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
    }

    @Test
    void getAllBinss_Empty() {
        Page<Bins> emptyPage = new PageImpl<>(List.of());
        when(binsRepository.findAll(any(PageRequest.class))).thenReturn(emptyPage);

        assertThrows(RuntimeException.class, () ->
            binsService.getAllBinss(PageRequest.of(0, 10))
        );
    }

    @Test
    void getBinsById_Success() {
        when(binsRepository.existsById(1L)).thenReturn(true);
        when(binsRepository.findById(1L)).thenReturn(Optional.of(bins));
        when(binsMapper.toResponse(any())).thenReturn(responseBinsDTO);

        ResponseBinsDTO result = binsService.getBinsById(1L);

        assertNotNull(result);
        verify(binsRepository).existsById(1L);
    }

    @Test
    void getBinsById_NotFound() {
        when(binsRepository.existsById(1L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () ->
            binsService.getBinsById(1L)
        );
    }

    @Test
    void deleteBins_Success() {
        when(binsRepository.findById(1L)).thenReturn(Optional.of(bins));

        boolean result = binsService.deleteBins(1L);

        assertTrue(result);
        verify(binsRepository).deleteById(1L);
    }

    @Test
    void deleteBins_NotFound() {
        when(binsRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () ->
            binsService.deleteBins(1L)
        );
    }

}