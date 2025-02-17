package projeto1com.example.Backend.filial.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto1com.example.Backend.filial.domain.model.Filial;
import projeto1com.example.Backend.filial.domain.service.FilialService;
import projeto1com.example.Backend.filial.interfaces.convert.FilialConverter;
import projeto1com.example.Backend.filial.interfaces.dto.FilialDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filial")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @Autowired
    private FilialConverter filialConverter;

    @PostMapping
    private ResponseEntity<FilialDto> createFilial(@RequestBody FilialDto filialDto) {
        Filial dadosFilial = filialConverter.createEntity(filialDto);
        Filial filialSalva = filialService.insert(dadosFilial);
        FilialDto filialSalvaDto = filialConverter.createDto(filialSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(filialSalvaDto);
    };

    @GetMapping
    private ResponseEntity<List<FilialDto>> getAllFilial() {
        List<Filial> listaFilial = filialService.findAll();
        List<FilialDto> listaFilialDto = new ArrayList<>();
        for (Filial filial : listaFilial) {
            FilialDto dto = filialConverter.createDto(filial);
            listaFilialDto.add(dto);
        }
        return ResponseEntity.ok(listaFilialDto);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FilialDto> getFilialById(@PathVariable UUID id) {
        Filial filial = filialService.findById(id);
        FilialDto dto = filialConverter.createDto(filial);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    private ResponseEntity<FilialDto> updateFilial(@PathVariable UUID id, @RequestBody FilialDto dto) {
        Filial filial = filialService.findById(id);
        filialConverter.updateEntity(dto, filial);
        Filial filialAlterada = filialService.insert(filial);
        FilialDto filialAlteradaDto = filialConverter.createDto(filialAlterada);
        return ResponseEntity.ok(filialAlteradaDto);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<FilialDto> deleteFilial(@PathVariable UUID id) {
        Filial filial = filialService.findById(id);
        filialService.delete(filial);
        return ResponseEntity.noContent().build();
    }
}
