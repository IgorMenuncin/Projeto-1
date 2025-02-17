package projeto1com.example.Backend.filial.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto1com.example.Backend.filial.domain.model.Filial;
import projeto1com.example.Backend.filial.domain.service.FilialService;
import projeto1com.example.Backend.filial.interfaces.convert.FilialConverter;
import projeto1com.example.Backend.filial.interfaces.dto.FilialDto;

@RestController
@RequestMapping("/filial")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @Autowired
    private FilialConverter filialConverter;

    private ResponseEntity<FilialDto> createFilial (@RequestBody FilialDto filialDto) {
        Filial dadosFilial = filialConverter.createEntity(filialDto);
        Filial filialSalva = filialService.insert(dadosFilial);
        FilialDto filialSalvaDto = filialConverter.createDto(filialSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(filialSalvaDto);
    };

}
