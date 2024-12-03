package com.wora.systemwastemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Vehicule;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
