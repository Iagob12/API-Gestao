package com.evento.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evento.api.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

    public Evento getByNome(String nome);

}
