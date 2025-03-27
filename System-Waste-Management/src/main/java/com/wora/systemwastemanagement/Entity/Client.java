package com.wora.systemwastemanagement.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client extends Utilisateur{
    @OneToMany(mappedBy = "client" , fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
    private List<Complaint> complaintList;
}
