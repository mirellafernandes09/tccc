package com.example.gestaosla.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tema é obrigatório")
    private String tema;

    @NotBlank(message = "Participantes são obrigatórios")
    private String participantes;

    @NotBlank(message = "Professor responsável é obrigatório")
    private String professor_ref;

    private String sala;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getProfessor_ref() {
        return professor_ref;
    }

    public void setProfessor_ref(String professor_ref) {
        this.professor_ref = professor_ref;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
