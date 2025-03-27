package com.wora.systemwastemanagement.Repository;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByUsername(String username);

    Optional<Client> findByEmail(@Email(message = "Email should be valid") String email);
}
