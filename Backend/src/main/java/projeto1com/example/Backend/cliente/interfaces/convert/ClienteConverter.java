package projeto1com.example.Backend.cliente.interfaces.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projeto1com.example.Backend.cliente.domain.model.Cliente;
import projeto1com.example.Backend.cliente.interfaces.dto.ClienteDto;
import projeto1com.example.Backend.usuario.domain.service.UsuarioService;

@Component
public class ClienteConverter {

    @Autowired
    private UsuarioService usuarioService;

    public Cliente createEntity(ClienteDto dto) {
        Cliente entity = new Cliente();
        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setDataCadastro(dto.getDataCadastro());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSituacao(dto.getSituacao());
        entity.setUsuario(usuarioService.findById(dto.getIdUsuario()));
        return entity;
    }

    public ClienteDto createDto(Cliente entity) {
        ClienteDto dto = new ClienteDto();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setNome(entity.getNome());
        dto.setDataCadastro(entity.getDataCadastro());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setSituacao(entity.getSituacao());
        dto.setIdUsuario(entity.getUsuario().getId());
        return dto;
    }

    public void updateEntity(ClienteDto dto, Cliente entity) {
        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setDataCadastro(dto.getDataCadastro());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSituacao(dto.getSituacao());
        entity.setUsuario(usuarioService.findById(dto.getIdUsuario()));
    }

}
