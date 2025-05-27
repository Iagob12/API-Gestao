package com.evento.api.controllers;

import com.evento.api.dto.EventoDTO;
import com.evento.api.services.EventoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listarEventos() {
        return ResponseEntity.ok(eventoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            EventoDTO evento = eventoService.buscarPorId(id);
            return ResponseEntity.ok(evento);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Evento não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity<EventoDTO> criarEvento(@RequestBody EventoDTO eventoDTO) {
        EventoDTO novoEvento = eventoService.criarEvento(eventoDTO);
        return ResponseEntity.status(201).body(novoEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {
        try {
            EventoDTO atualizado = eventoService.atualizarEvento(id, eventoDTO);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Evento não encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id) {
        try {
            eventoService.deletarEvento(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Evento não encontrado.");
        }
    }

    @PostMapping("/{eventoId}/participantes/{participanteId}")
    public ResponseEntity<?> inscreverParticipante(@PathVariable Long eventoId, @PathVariable Long participanteId) {
        try {
            EventoDTO eventoAtualizado = eventoService.inscreverParticipante(eventoId, participanteId);
            return ResponseEntity.ok(eventoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{eventoId}/participantes")
    public ResponseEntity<?> listarParticipantes(@PathVariable Long eventoId) {
        try {
            return ResponseEntity.ok(eventoService.listarParticipantes(eventoId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("Evento não encontrado.");
        }
    }
}
