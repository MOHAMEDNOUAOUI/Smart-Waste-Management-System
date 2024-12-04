package com.wora.systemwastemanagement.Service.Impl;

import com.wora.systemwastemanagement.Config.JwtTokenUtil;
import com.wora.systemwastemanagement.DTO.LoginRequestDTO;
import com.wora.systemwastemanagement.DTO.LoginResponseDTO;
import com.wora.systemwastemanagement.DTO.RegisterRequestDTO;
import com.wora.systemwastemanagement.Entity.Enum.Role;
import com.wora.systemwastemanagement.Entity.Utilisateur;
import com.wora.systemwastemanagement.Repository.UtilisateurRepository;
import com.wora.systemwastemanagement.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        String token = jwtTokenUtil.generateToken(authentication);

        String role = authentication.getAuthorities().stream().findFirst().get().getAuthority();

        return new LoginResponseDTO(token, role);
    }

    public String register(RegisterRequestDTO registerRequest) {
        Utilisateur utilisateur = utilisateurRepository.findByUsername(registerRequest.getUsername())
                .orElseThrow(() ->  new IllegalArgumentException("Username is already taken."));

        Utilisateur user = new Utilisateur();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setRole(Role.ROLE_USER);

        utilisateurRepository.save(utilisateur);
        return "User registered successfully!";
    }
}
