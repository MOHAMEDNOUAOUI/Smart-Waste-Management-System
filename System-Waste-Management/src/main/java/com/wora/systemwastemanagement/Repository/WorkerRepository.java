package com.wora.systemwastemanagement.Repository;
import jakarta.validation.constraints.Email;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Worker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    List<Worker> email(@Email(message = "Email should be valid") String email);
    Optional<Worker> findByEmail(@Email(message = "Email should be valid") String email);
}
