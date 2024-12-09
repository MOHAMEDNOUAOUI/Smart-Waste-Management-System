package com.wora.apidegestiondescoupesdefootball.Entity;
import com.wora.apidegestiondescoupesdefootball.Entity.Enum.ROLE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "utilisateur")
public class Utilisateur {
    @Id
    private String id;
    private String username;
    private String password;
    private ROLE role;

}
