package com.wora.systemwastemanagement.Service;

import com.wora.systemwastemanagement.DTO.LoginRequestDTO;
import com.wora.systemwastemanagement.DTO.LoginResponseDTO;
import com.wora.systemwastemanagement.DTO.RegisterRequestDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    String register(RegisterRequestDTO registerRequestDTO);
}
