package com.evento.api.controllers;

import com.evento.api.dto.ParticipanteDTO;
import com.evento.api.services.ParticipanteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<ParticipanteDTO>> listarParticipantes() {
        return ResponseEntity.ok(participanteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            ParticipanteDTO dto = participanteService.buscarPorId(id);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Participante não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity<?> criarParticipante(@RequestBody ParticipanteDTO dto) {
        try {
            ParticipanteDTO criado = participanteService.criarParticipante(dto);
            return ResponseEntity.status(201).body(criado);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao criar participante: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarParticipante(@PathVariable Long id, @RequestBody ParticipanteDTO dto) {
        try {
            ParticipanteDTO atualizado = participanteService.atualizarParticipante(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Participante não encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao atualizar participante: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarParticipante(@PathVariable Long id) {
        try {
            participanteService.deletarParticipante(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Participante não encontrado.");
        }
    }
}
