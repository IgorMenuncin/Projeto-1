package projeto1com.example.Backend.cliente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto1com.example.Backend.cliente.domain.model.Cliente;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
