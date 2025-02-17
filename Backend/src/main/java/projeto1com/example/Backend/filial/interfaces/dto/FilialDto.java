package projeto1com.example.Backend.filial.interfaces.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import projeto1com.example.Backend.filial.domain.model.enums.SituacaoFilial;

import java.util.UUID;

@Data
@NoArgsConstructor
public class FilialDto {

    private UUID id;

    private Integer codigo;

    private String nome;

    private String cidade;

    private String estado;

    private String pais;

    private SituacaoFilial situacao;

}
