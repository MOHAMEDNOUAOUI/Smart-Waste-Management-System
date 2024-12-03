package com.wora.systemwastemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Roots;
import org.springframework.stereotype.Repository;

@Repository
public interface RootsRepository extends JpaRepository<Roots,Long> {
}
