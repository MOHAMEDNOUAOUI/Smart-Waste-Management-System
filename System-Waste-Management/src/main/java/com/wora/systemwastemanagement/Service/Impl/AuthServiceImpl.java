package com.wora.systemwastemanagement.Service.Impl;

import com.wora.systemwastemanagement.Config.JwtTokenUtil;
import com.wora.systemwastemanagement.DTO.Client.CreateClientDTO;
import com.wora.systemwastemanagement.DTO.Client.ResponseClientDTO;
import com.wora.systemwastemanagement.DTO.LoginRequestDTO;
import com.wora.systemwastemanagement.DTO.LoginResponseDTO;
import com.wora.systemwastemanagement.DTO.Worker.CreateWorkerDTO;
import com.wora.systemwastemanagement.DTO.Worker.ResponseWorkerDTO;
import com.wora.systemwastemanagement.Entity.Enum.Rrole;
import com.wora.systemwastemanagement.Entity.Utilisateur;
import com.wora.systemwastemanagement.Mapper.ClientMapper;
import com.wora.systemwastemanagement.Repository.UtilisateurRepository;
import com.wora.systemwastemanagement.Repository.WorkerRepository;
import com.wora.systemwastemanagement.Service.AdminService;
import com.wora.systemwastemanagement.Service.AuthService;
import com.wora.systemwastemanagement.Service.ClientService;
import com.wora.systemwastemanagement.Service.WorkerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientService clientService;
    private final WorkerService workerService;
    private final AdminService adminService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmail(loginRequest.getEmail());
        if (utilisateurOpt.isEmpty()) {
            throw new UsernameNotFoundException("Email not found.");
        }
        Utilisateur utilisateur = utilisateurOpt.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), utilisateur.getPassword())) {
            throw new BadCredentialsException("Invalid password.");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        Rrole role = utilisateur.getRrole();
        String token = jwtTokenUtil.generateToken(authentication , role.toString());
        return new LoginResponseDTO(token);
    }

    @Override
    public String register(CreateClientDTO createClientDTO) {
        if (utilisateurRepository.existsByUsername(createClientDTO.getUsername())) {
            throw new IllegalArgumentException("Username is already taken.");
        }
        if (utilisateurRepository.existsByEmail(createClientDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }

        String encodedPassword = passwordEncoder.encode(createClientDTO.getPassword());
        createClientDTO.setPassword(encodedPassword);
        createClientDTO.setRrole(Rrole.ROLE_USER);
        clientService.createClient(createClientDTO);
        return "User registered successfully!";
    }


    @Override
    public Object getUtilisateur() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.User springUserDetails) {
            String email = springUserDetails.getUsername();
            Rrole rrole = Rrole.valueOf(springUserDetails.getAuthorities().iterator().next().getAuthority());   
            Utilisateur user = utilisateurRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
            if (rrole == Rrole.ROLE_WORKER){
                return workerService.getWorkerById(user.getId());
            }else if (rrole ==Rrole.ROLE_USER){
                return clientService.getClientById(user.getId());
            }else if(rrole ==Rrole.ROLE_ADMIN){
                return adminService.getAdminById(user.getId());
            }
        }
        return null;
    }



}
