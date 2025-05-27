package com.evento.api.services;

import com.evento.api.dto.ParticipanteDTO;
import com.evento.api.entity.Participante;
import com.evento.api.repositories.ParticipanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public ParticipanteDTO criarParticipante(ParticipanteDTO dto) {
        Participante participante = ParticipanteDTO.toEntity(dto);
        return new ParticipanteDTO(participanteRepository.save(participante));
    }

    public ParticipanteDTO atualizarParticipante(Long id, ParticipanteDTO dto) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));
        participante.setNome(dto.getNome());
        participante.setEmail(dto.getEmail());
        return new ParticipanteDTO(participanteRepository.save(participante));
    }

    public void deletarParticipante(Long id) {
        participanteRepository.deleteById(id);
    }

    public ParticipanteDTO buscarPorId(Long id) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));
        return new ParticipanteDTO(participante);
    }

    public List<ParticipanteDTO> listarTodos() {
        return participanteRepository.findAll()
                .stream()
                .map(ParticipanteDTO::new)
                .collect(Collectors.toList());
    }
}
