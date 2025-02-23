package projeto1com.example.Backend.usuario.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import projeto1com.example.Backend.filial.domain.model.Filial;
import projeto1com.example.Backend.usuario.domain.model.enums.SituacaoUsuario;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "usu_usuario")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "situacao")
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private SituacaoUsuario situacao;

    @ManyToOne
    @JoinColumn(name = "id_filial", referencedColumnName = "id")
    private Filial filial;

}
