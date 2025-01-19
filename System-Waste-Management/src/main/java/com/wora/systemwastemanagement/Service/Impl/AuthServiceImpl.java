package com.wora.systemwastemanagement.Service.Impl;

import com.wora.systemwastemanagement.Config.JwtTokenUtil;
import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.LoginRequestDTO;
import com.wora.systemwastemanagement.DTO.LoginResponseDTO;
import com.wora.systemwastemanagement.Entity.Utilisateur;
import com.wora.systemwastemanagement.Repository.UtilisateurRepository;
import com.wora.systemwastemanagement.Service.AuthService;
import com.wora.systemwastemanagement.Service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientService clientService;

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

    @Override
    public String register(CreateClientDTO createClientDTO) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(createClientDTO.getUsername());
        if (utilisateur.isPresent()) {
            return "Username is already taken.";
        }
        String encodedPassword = passwordEncoder.encode(createClientDTO.getPassword());
        createClientDTO.setPassword(encodedPassword);
        clientService.createClient(createClientDTO);
        return "User registered successfully!";
    }


}
