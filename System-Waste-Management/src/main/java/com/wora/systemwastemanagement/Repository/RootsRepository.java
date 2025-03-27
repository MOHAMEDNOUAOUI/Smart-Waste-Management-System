package com.wora.systemwastemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Roots;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RootsRepository extends JpaRepository<Roots,Long> {
    List<Roots> findAllByVehicule_AssignedWorker_Email(String email);
}
