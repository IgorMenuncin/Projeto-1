package projeto1com.example.Backend.filial.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto1com.example.Backend.filial.domain.model.Filial;

import java.util.Optional;
import java.util.UUID;

public interface FilialRepository extends JpaRepository<Filial, UUID> {

    Optional<Filial> findByNome(String nome);

}
