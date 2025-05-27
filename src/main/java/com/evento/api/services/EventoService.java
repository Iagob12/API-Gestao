package com.evento.api.service;

import com.evento.api.entity.Evento;
import com.evento.api.entity.Participante;
import com.evento.api.repositories.EventoRepository;
import com.evento.api.repositories.ParticipanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    // CRUD

    public Evento criarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento atualizarEvento(Long id, Evento eventoAtualizado) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
        evento.setNome(eventoAtualizado.getNome());
        evento.setDescricao(eventoAtualizado.getDescricao());
        evento.setData(eventoAtualizado.getData());
        evento.setLocal(eventoAtualizado.getLocal());
        evento.setVagas(eventoAtualizado.getVagas());
        return eventoRepository.save(evento);
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
    }

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    // Inscrição de Participante

    public Evento inscreverParticipante(Long eventoId, Long participanteId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
        Participante participante = participanteRepository.findById(participanteId)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));

        if (evento.getVagas() <= 0) {
            throw new IllegalStateException("Não há vagas disponíveis para este evento.");
        }

        if (evento.getParticipantes().contains(participante)) {
            throw new IllegalStateException("Participante já inscrito neste evento.");
        }

        evento.getParticipantes().add(participante);
        evento.setVagas(evento.getVagas() - 1);

        return eventoRepository.save(evento);
    }
}
