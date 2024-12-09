package com.wora.apidegestiondescoupesdefootball.Config;

import com.wora.apidegestiondescoupesdefootball.Entity.Utilisateur;
import com.wora.apidegestiondescoupesdefootball.Repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UtilisateurRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(utilisateur.getUsername())
                .password(utilisateur.getPassword())
                .roles(utilisateur.getRole().name())
                .build();
    }


}
