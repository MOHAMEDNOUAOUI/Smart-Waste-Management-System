package com.wora.systemwastemanagement.Controller;


import com.wora.systemwastemanagement.Config.JwtTokenUtil;
import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.LoginRequestDTO;
import com.wora.systemwastemanagement.DTO.LoginResponseDTO;
import com.wora.systemwastemanagement.DTO.RequestRefreshToken;
import com.wora.systemwastemanagement.Entity.Enum.Rrole;
import com.wora.systemwastemanagement.Entity.Utilisateur;
import com.wora.systemwastemanagement.Service.AuthService;
import com.wora.systemwastemanagement.Service.ClientService;
import com.wora.systemwastemanagement.Service.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenUtil jwtTokenUtil;

    // Endpoint for Login
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateClientDTO createClientDTO) {
        String response = authService.register(createClientDTO);
        return ResponseEntity.ok(Map.of("message", response));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getAuthenticatedUser() {
        Object utilisateur = authService.getUtilisateur();
        if (utilisateur == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not authenticated");
        }
        return ResponseEntity.ok(utilisateur);
    }



}
