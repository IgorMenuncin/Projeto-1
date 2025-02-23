package projeto1com.example.Backend.cliente.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto1com.example.Backend.cliente.domain.model.Cliente;
import projeto1com.example.Backend.cliente.domain.repository.ClienteRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public Cliente findById(UUID id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

}
