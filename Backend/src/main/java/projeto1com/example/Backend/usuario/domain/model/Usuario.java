package projeto1com.example.Backend.usuario.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Usuario {

    @Id
    private UUID id;

    private String nome;

    private String email;

    private String senha;

}
