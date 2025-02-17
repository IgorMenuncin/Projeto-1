package projeto1com.example.Backend.filial.interfaces.convert;

import org.springframework.stereotype.Component;
import projeto1com.example.Backend.filial.domain.model.Filial;
import projeto1com.example.Backend.filial.interfaces.dto.FilialDto;

@Component
public class FilialConverter {

    public Filial createEntity(FilialDto dto) {
        Filial entity = new Filial();
        entity.setId(dto.getId());
        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setPais(dto.getPais());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }

    public FilialDto createDto(Filial entity) {
        FilialDto dto = new FilialDto();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setNome(entity.getNome());
        dto.setCidade(entity.getCidade());
        dto.setEstado(entity.getEstado());
        dto.setPais(entity.getPais());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public void updateEntity(FilialDto dto, Filial entity) {
        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setPais(dto.getPais());
        entity.setSituacao(dto.getSituacao());
    }

}
