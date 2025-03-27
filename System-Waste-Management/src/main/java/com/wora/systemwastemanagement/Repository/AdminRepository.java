package com.wora.systemwastemanagement.Repository;

import com.wora.systemwastemanagement.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
