package com.wora.systemwastemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Bins;
import org.springframework.stereotype.Repository;

@Repository
public interface BinsRepository extends JpaRepository<Bins,Long> {
}
