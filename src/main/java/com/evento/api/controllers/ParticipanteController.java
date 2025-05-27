package com.evento.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.evento.api.dto.ParticipanteDTO;
import com.evento.api.services.ParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteDTO>> listarParticipantes() {
        List<ParticipanteDTO> participantes = participanteService.listarTodos();
        return ResponseEntity.ok(participantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> buscarPorId(@PathVariable Long id) {
        ParticipanteDTO participante = participanteService.buscarPorId(id);
        return ResponseEntity.ok(participante);
    }

    @PostMapping
    public ResponseEntity<ParticipanteDTO> criarParticipante(@RequestBody ParticipanteDTO dto) {
        ParticipanteDTO participanteCriado = participanteService.criarParticipante(dto);
        return ResponseEntity.status(201).body(participanteCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipanteDTO> atualizarParticipante(@PathVariable Long id, @RequestBody ParticipanteDTO dto) {
        ParticipanteDTO participanteAtualizado = participanteService.atualizarParticipante(id, dto);
        return ResponseEntity.ok(participanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarParticipante(@PathVariable Long id) {
        participanteService.deletarParticipante(id);
        return ResponseEntity.noContent().build();
    }
}
