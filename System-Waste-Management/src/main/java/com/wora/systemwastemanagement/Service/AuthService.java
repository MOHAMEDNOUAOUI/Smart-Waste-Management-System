package com.wora.systemwastemanagement.Service;

import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.LoginRequestDTO;
import com.wora.systemwastemanagement.DTO.LoginResponseDTO;
import com.wora.systemwastemanagement.Entity.Utilisateur;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    String register(CreateClientDTO createClientDTO);
    Object getUtilisateur();
}
