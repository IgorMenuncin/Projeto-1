package projeto1com.example.Backend.usuario.interfaces.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projeto1com.example.Backend.filial.domain.service.FilialService;
import projeto1com.example.Backend.usuario.domain.model.Usuario;
import projeto1com.example.Backend.usuario.interfaces.dto.UsuarioDto;

@Component
public class UsuarioConverter {

    @Autowired
    private FilialService filialService;

    public Usuario createEntity(UsuarioDto dto) {
        Usuario entity = new Usuario();
        entity.setCodigo(dto.getCodigo());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setSituacao(dto.getSituacao());
        entity.setFilial(filialService.findById(dto.getIdFilial()));
        return entity;
    }

    public UsuarioDto createDto(Usuario entity) {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setNome(entity.getNome());
        dto.setTelefone(entity.getTelefone());
        dto.setSituacao(entity.getSituacao());
        dto.setIdFilial(entity.getFilial().getId());
        return dto;
    }

    public void updateEntity(UsuarioDto dto, Usuario entity) {
        entity.setCodigo(dto.getCodigo());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setSituacao(dto.getSituacao());
        entity.setFilial(filialService.findById(dto.getIdFilial()));
    }

}
