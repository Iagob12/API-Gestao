package com.evento.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evento.api.entity.Evento;
import com.evento.api.entity.Participante;
import com.evento.api.services.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Evento buscarPorId(@PathVariable Long id) {
        return eventoService.buscarPorId(id);
    }

    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento) {
        return eventoService.salvar(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        return eventoService.atualizar(id, evento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEvento(@PathVariable Long id) {
        return eventoService.deletar(id);
    }

    @PostMapping("/{id}/participantes")
    public ResponseEntity<Evento> adicionarParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        return eventoService.adicionarParticipante(id, participante);
    }

    @GetMapping("/{id}/participantes")
    public ResponseEntity<List<Participante>> listarParticipantes(@PathVariable Long id) {
        return eventoService.listarParticipantes(id);
    }

}
