package com.wora.systemwastemanagement.Controller;


import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.LoginRequestDTO;
import com.wora.systemwastemanagement.DTO.LoginResponseDTO;
import com.wora.systemwastemanagement.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AuthController {

    private final AuthService authService;

    // Endpoint for Login
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateClientDTO createClientDTO) {
        String response = authService.register(createClientDTO);
        if (response.equals("Username is already taken.")){

        }
        return ResponseEntity.ok(Map.of("message", response));
    }

}
