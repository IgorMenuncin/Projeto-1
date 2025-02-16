package projeto1com.example.Backend.usuario.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto1com.example.Backend.usuario.domain.model.Usuario;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
