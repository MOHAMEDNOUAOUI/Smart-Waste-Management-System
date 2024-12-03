package com.wora.systemwastemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
