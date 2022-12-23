package br.com.pifalafatec.repository;

import br.com.pifalafatec.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventosRepository extends JpaRepository<Eventos, Long> {

    List<Eventos> findByNome(String nome);
    List<Eventos> deleteByData(String data);

}
