package br.com.pifalafatec.controller;

import br.com.pifalafatec.entity.Eventos;
import br.com.pifalafatec.repository.EventosRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class EventosController {

    EventosRepository repository;

    @GetMapping("/evento")
    public List<Eventos> getAllEventos(){
        return repository.findAll();
    }

    @GetMapping("/evento/nome")
    public ResponseEntity<List<Eventos>> getEventoByNome(@RequestParam String nome){
        return new ResponseEntity<List<Eventos>>(repository.findByNome(nome), HttpStatus.OK);
    }


    @PostMapping("/evento")
    public ResponseEntity<Eventos> saveEvento(@RequestBody Eventos eventos) {
        return ResponseEntity.ok(repository.save(eventos));
    }

    @PutMapping("/evento/{id}")
    public Eventos updateEvento(@PathVariable long id, @RequestBody Eventos eventos){
        Eventos evento = repository.findById(id).get();
        evento.setNome(eventos.getNome());
        evento.setData(eventos.getData());
        evento.setDescricao(eventos.getDescricao());
        evento.setHora(eventos.getHora());
        evento.setPalestrante(eventos.getPalestrante());

        return repository.save(evento);
    }

    @Transactional
    @DeleteMapping("/evento/data")
    public void deleteEvento(@RequestParam String data){
        //repository.deleteById(id);
        repository.deleteByData(data);
    }


}
