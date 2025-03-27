package com.wora.systemwastemanagement.Repository;
import com.wora.systemwastemanagement.DTO.Complaint.ResponseComplaintDTO;
import com.wora.systemwastemanagement.Entity.Client;
import com.wora.systemwastemanagement.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wora.systemwastemanagement.Entity.Complaint;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    List<Complaint> findAllByBins_Route_Vehicule_AssignedWorker(Worker bins_route_vehicule_assignedWorker);

    List<Complaint> findAllByClient_Id(Long clientId);
}
