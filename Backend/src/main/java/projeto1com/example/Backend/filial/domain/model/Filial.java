package projeto1com.example.Backend.filial.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto1com.example.Backend.filial.domain.model.enums.SituacaoFilial;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "fil_filial")
public class Filial {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @Column(name = "situacao")
    private SituacaoFilial situacao;
}
