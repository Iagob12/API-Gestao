package com.evento.api.services;

import com.evento.api.dto.EventoDTO;
import com.evento.api.entity.Evento;
import com.evento.api.entity.Participante;
import com.evento.api.repositories.EventoRepository;
import com.evento.api.repositories.ParticipanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evento.api.dto.ParticipanteDTO;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    public EventoDTO criarEvento(EventoDTO dto) {
        Evento evento = EventoDTO.toEntity(dto);
        return new EventoDTO(eventoRepository.save(evento));
    }

    public EventoDTO atualizarEvento(Long id, EventoDTO dto) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
        evento.setNome(dto.getNome());
        evento.setDescricao(dto.getDescricao());
        evento.setData(dto.getData());
        evento.setLocal(dto.getLocal());
        evento.setVagas(dto.getVagas());
        return new EventoDTO(eventoRepository.save(evento));
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public EventoDTO buscarPorId(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
        return new EventoDTO(evento);
    }

    public List<EventoDTO> listarTodos() {
        return eventoRepository.findAll()
                .stream()
                .map(EventoDTO::new)
                .collect(Collectors.toList());
    }


    public EventoDTO inscreverParticipante(Long eventoId, Long participanteId) {
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

        return new EventoDTO(eventoRepository.save(evento));
    }



    public List<ParticipanteDTO> listarParticipantes(Long eventoId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));

        return evento.getParticipantes()
                .stream()
                .map(ParticipanteDTO::new)  // Converte entidade para DTO
                .collect(Collectors.toList());
    }

}
