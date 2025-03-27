package com.wora.systemwastemanagement.Service.Impl;

import com.wora.systemwastemanagement.DTO.Utilisateur.CreateUtilisateurDTO;
import com.wora.systemwastemanagement.DTO.Utilisateur.ResponseUtilisateurDTO;
import com.wora.systemwastemanagement.Entity.Admin;
import com.wora.systemwastemanagement.Mapper.AdminMapper;
import com.wora.systemwastemanagement.Repository.AdminRepository;
import com.wora.systemwastemanagement.Service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Override
    public ResponseUtilisateurDTO createAdmin(CreateUtilisateurDTO createUtilisateurDTO) {
        Admin admin = adminMapper.toEntity(createUtilisateurDTO);
        return adminMapper.toResponse(adminRepository.save(admin));
    }

    @Override
    public Page<ResponseUtilisateurDTO> getAllAdmins(Pageable pageable) {
        Page<Admin> admins = adminRepository.findAll(pageable);
        if (admins.isEmpty()) {
            throw new RuntimeException("No admins found");
        }
        return admins.map(adminMapper::toResponse);
    }

    @Override
    public ResponseUtilisateurDTO getAdminById(Long id) {
        if (adminRepository.existsById(id)) {
            return adminMapper.toResponse(adminRepository.findById(id).get());
        }
        throw new RuntimeException("No admin found");
    }

    @Override
    public ResponseUtilisateurDTO updateClient(CreateUtilisateurDTO createUtilisateurDTO, Long id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No admin found"));
        adminMapper.updateAdmin(createUtilisateurDTO, admin);
        return adminMapper.toResponse(adminRepository.save(admin));
    }

    @Override
    public void deleteAdmin(Long id) {
        if(!adminRepository.existsById(id)) {
            throw new RuntimeException("No admin found");
        }
        adminRepository.deleteById(id);
    }
}
