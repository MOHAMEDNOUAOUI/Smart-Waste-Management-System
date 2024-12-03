package com.wora.systemwastemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Worker;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
