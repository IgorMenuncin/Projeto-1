package projeto1com.example.Backend.cliente.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import projeto1com.example.Backend.cliente.domain.model.enums.SituacaoCliente;
import projeto1com.example.Backend.usuario.domain.model.Usuario;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cli_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "situacao")
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private SituacaoCliente situacao;

    @Column(name = "id_usuario")
    private Usuario usuario;

}
