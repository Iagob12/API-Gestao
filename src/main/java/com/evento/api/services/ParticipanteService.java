package com.evento.api.services;

import com.evento.api.entity.Participante;
import com.evento.api.repositories.ParticipanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public Participante criarParticipante(Participante participante) {
        return participanteRepository.save(participante);
    }

    public Participante atualizarParticipante(Long id, Participante participanteAtualizado) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));
        participante.setNome(participanteAtualizado.getNome());
        participante.setEmail(participanteAtualizado.getEmail());
        participante.setTelefone(participanteAtualizado.getTelefone());
        return participanteRepository.save(participante);
    }

    public void deletarParticipante(Long id) {
        participanteRepository.deleteById(id);
    }

    public Participante buscarPorId(Long id) {
        return participanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));
    }

    public List<Participante> listarTodos() {
        return participanteRepository.findAll();
    }
}
