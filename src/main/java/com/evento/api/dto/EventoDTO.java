package com.evento.api.dto;

import java.time.LocalDate;

import com.evento.api.entity.Evento;

public class EventoDTO {

    private Long id;
	private String nome;
	private String descricao;
	private LocalDate data;
	private String local;
	private Integer vagas;

    public EventoDTO() {
    }

    public EventoDTO(Long id, String nome, String descricao, LocalDate data, String local, Integer vagas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.vagas = vagas;
    }

    public EventoDTO(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.descricao = evento.getDescricao();
        this.data = evento.getData();
        this.local = evento.getLocal();
        this.vagas = evento.getVagas();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    

}
