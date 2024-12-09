package com.wora.apidegestiondescoupesdefootball.Repository;
import com.wora.apidegestiondescoupesdefootball.Entity.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends MongoRepository<Utilisateur,String> {
    Optional<Utilisateur> findByUsername(String username);
}
