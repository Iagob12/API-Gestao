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

import com.evento.api.entity.Participante;
import com.evento.api.services.ParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<Participante> listarParticipantes() {
        return ParticipanteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Participante buscarPorId(@PathVariable Long id) {
        return ParticipanteService.buscarPorId(id);
    }

    @PostMapping
    public Participante criarParticipante(@RequestBody Participante participante) {
        return participanteService.salvar(participante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participante> atualizarParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        return participanteService.atualizar(id, participante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarParticipante(@PathVariable Long id) {
        return participanteService.deletar(id);
    }
}
