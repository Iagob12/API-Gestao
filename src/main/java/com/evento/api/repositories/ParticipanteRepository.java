package com.evento.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evento.api.entity.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}
