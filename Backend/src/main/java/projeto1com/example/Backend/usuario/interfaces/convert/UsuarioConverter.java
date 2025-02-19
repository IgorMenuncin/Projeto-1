package projeto1com.example.Backend.usuario.interfaces.convert;

import projeto1com.example.Backend.usuario.domain.model.Usuario;
import projeto1com.example.Backend.usuario.interfaces.dto.UsuarioDto;

public class UsuarioConverter {

    public Usuario createEntity(UsuarioDto dto) {
        Usuario entity = new Usuario();
        entity.setCodigo(dto.getCodigo());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }

    public UsuarioDto createDto(Usuario entity) {
        UsuarioDto dto = new UsuarioDto();
        dto.setCodigo(entity.getCodigo());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setNome(entity.getNome());
        dto.setTelefone(entity.getTelefone());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public void updateEntity(UsuarioDto dto, Usuario entity) {
        entity.setCodigo(dto.getCodigo());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setSituacao(dto.getSituacao());
    }

}
