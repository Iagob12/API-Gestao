package com.evento.api.dto;

import com.evento.api.entity.Participante;

public class ParticipanteDTO {

    private Long id;
    private String nome;
    private String email;

    public ParticipanteDTO() {
    }

    public ParticipanteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ParticipanteDTO(Participante participante) {
        this.id = participante.getId();
        this.nome = participante.getNome();
        this.email = participante.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
