package projeto1com.example.Backend.usuario.interfaces.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import projeto1com.example.Backend.usuario.domain.model.enums.SituacaoUsuario;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UsuarioDto {

    private UUID id;

    private Integer codigo;

    private String email;

    private String senha;

    private String nome;

    private String telefone;

    private SituacaoUsuario situacao;

}
