package projeto1com.example.Backend.filial.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto1com.example.Backend.filial.domain.model.Filial;
import projeto1com.example.Backend.filial.domain.repository.FilialRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;

    public Filial insert(Filial filial) {
        return filialRepository.save(filial);
    }

    public Filial update(Filial filial) {
        return filialRepository.save(filial);
    }

    public void delete (Filial filial) {
        filialRepository.delete(filial);
    }

    public Filial findById(UUID id) {
        return filialRepository.findById(id).orElse(null);
    }

    public List<Filial> findAll() {
        return filialRepository.findAll();
    }
}
