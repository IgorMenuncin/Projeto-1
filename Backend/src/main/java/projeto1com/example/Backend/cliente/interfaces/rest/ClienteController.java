package projeto1com.example.Backend.cliente.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto1com.example.Backend.cliente.domain.model.Cliente;
import projeto1com.example.Backend.cliente.domain.service.ClienteService;
import projeto1com.example.Backend.cliente.interfaces.convert.ClienteConverter;
import projeto1com.example.Backend.cliente.interfaces.dto.ClienteDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteConverter clienteConverter;

    @PostMapping
    private ResponseEntity<ClienteDto> createCliente (@RequestBody ClienteDto dto) {
        Cliente dadosCliente = clienteConverter.createEntity(dto);
        Cliente clienteSalvo = clienteService.insert(dadosCliente);
        ClienteDto clienteSalvoDto = clienteConverter.createDto(clienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvoDto);
    }

    @GetMapping
    private ResponseEntity<List<ClienteDto>> getAllCliente() {
        List<Cliente> listaClientes = clienteService.findAll();
        List<ClienteDto> listaClientesDto = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            ClienteDto dto = clienteConverter.createDto(cliente);
            listaClientesDto.add(dto);
        }
        return ResponseEntity.ok(listaClientesDto);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClienteDto> getClienteById(@PathVariable UUID id) {
        Cliente cliente = clienteService.findById(id);
        ClienteDto dto = clienteConverter.createDto(cliente);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ClienteDto> updateCliente(@PathVariable UUID id, @RequestBody ClienteDto dto) {
        Cliente cliente = clienteService.findById(id);
        clienteConverter.updateEntity(dto, cliente);
        Cliente clienteAlterado = clienteService.insert(cliente);
        ClienteDto clienteAlteradoDto = clienteConverter.createDto(clienteAlterado);
        return ResponseEntity.ok(clienteAlteradoDto);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ClienteDto> deleteCliente(@PathVariable UUID id) {
        Cliente cliente = clienteService.findById(id);
        clienteService.delete(cliente);
        return ResponseEntity.noContent().build();
    }

}
