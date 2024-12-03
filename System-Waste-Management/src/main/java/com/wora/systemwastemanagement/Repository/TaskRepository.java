package com.wora.systemwastemanagement.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
