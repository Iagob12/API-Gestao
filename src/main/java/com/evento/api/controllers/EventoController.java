package com.evento.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.evento.api.dto.EventoDTO;
import com.evento.api.dto.ParticipanteDTO;
import com.evento.api.services.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listarEventos() {
        List<EventoDTO> eventos = eventoService.listarTodos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> buscarPorId(@PathVariable Long id) {
        EventoDTO evento = eventoService.buscarPorId(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<EventoDTO> criarEvento(@RequestBody EventoDTO dto) {
        EventoDTO eventoCriado = eventoService.criarEvento(dto);
        return ResponseEntity.status(201).body(eventoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> atualizarEvento(@PathVariable Long id, @RequestBody EventoDTO dto) {
        EventoDTO eventoAtualizado = eventoService.atualizarEvento(id, dto);
        return ResponseEntity.ok(eventoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/participantes")
    public ResponseEntity<EventoDTO> adicionarParticipante(@PathVariable Long id, @RequestBody ParticipanteDTO participanteDto) {
        EventoDTO eventoAtualizado = eventoService.inscreverParticipante(id, participanteDto.getId());
        return ResponseEntity.ok(eventoAtualizado);
    }

    @GetMapping("/{id}/participantes")
    public ResponseEntity<List<ParticipanteDTO>> listarParticipantes(@PathVariable Long id) {
        List<ParticipanteDTO> participantes = eventoService.listarParticipantes(id);
        return ResponseEntity.ok(participantes);
    }
}
