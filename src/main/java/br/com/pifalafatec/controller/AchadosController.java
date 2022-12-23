package br.com.pifalafatec.controller;

import br.com.pifalafatec.entity.Achados;
import br.com.pifalafatec.entity.Eventos;
import br.com.pifalafatec.repository.AchadosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class AchadosController {

    AchadosRepository repository;

    @GetMapping("/achadoseperdidos")
    public List<Achados> getAllAchados(){
        return repository.findAll();
    }

    @PostMapping("/achadoseperdidos")
    public ResponseEntity<Achados> saveAchado(@RequestBody Achados achados) {
        return ResponseEntity.ok(repository.save(achados));
    }


}
