package projeto1com.example.Backend.usuario.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto1com.example.Backend.usuario.domain.model.Usuario;
import projeto1com.example.Backend.usuario.domain.service.UsuarioService;
import projeto1com.example.Backend.usuario.interfaces.convert.UsuarioConverter;
import projeto1com.example.Backend.usuario.interfaces.dto.UsuarioDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @PostMapping
    private ResponseEntity<UsuarioDto> createUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario dadosUsuario = usuarioConverter.createEntity(usuarioDto);
        Usuario usuarioSalvo = usuarioService.insert(dadosUsuario);
        UsuarioDto usuarioSalvoDto = usuarioConverter.createDto(usuarioSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvoDto);
    }

    @GetMapping
    private ResponseEntity<List<UsuarioDto>> getAllUsuario() {
        List<Usuario> listaUsuarios = usuarioService.findAll();
        List<UsuarioDto> listaUsuariosDto = new ArrayList<>();
        for (Usuario usuario : listaUsuarios) {
            UsuarioDto dto = usuarioConverter.createDto(usuario);
            listaUsuariosDto.add(dto);
        }
        return ResponseEntity.ok(listaUsuariosDto);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable UUID id) {
        Usuario usuario = usuarioService.findById(id);
        UsuarioDto dto = usuarioConverter.createDto(usuario);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    private ResponseEntity<UsuarioDto> updateUsuario(@PathVariable UUID id, @RequestBody UsuarioDto dto) {
        Usuario usuario = usuarioService.findById(id);
        usuarioConverter.updateEntity(dto, usuario);
        Usuario usuarioAlterado = usuarioService.insert(usuario);
        UsuarioDto usuarioAlteradoDto = usuarioConverter.createDto(usuarioAlterado);
        return ResponseEntity.ok(usuarioAlteradoDto);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<UsuarioDto> deleteUsuario(@PathVariable UUID id) {
        Usuario usuario = usuarioService.findById(id);
        usuarioService.delete(usuario);
        return ResponseEntity.noContent().build();
    }

}
