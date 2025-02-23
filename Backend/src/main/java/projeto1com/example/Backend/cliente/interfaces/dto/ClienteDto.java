package projeto1com.example.Backend.cliente.interfaces.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import projeto1com.example.Backend.cliente.domain.model.enums.SituacaoCliente;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ClienteDto {

    private UUID id;

    private Integer codigo;

    private String nome;

    private LocalDate dataCadastro;

    private LocalDate dataNascimento;

    private SituacaoCliente situacao;

    private UUID idUsuario;

}
